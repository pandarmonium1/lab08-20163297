package controller.proform;
import java.util.*;
import java.io.IOException;  
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jws.WebService;
import javax.servlet.*;  
import javax.servlet.http.*;

import com.google.appengine.api.users.UserServiceFactory;

import pmf.entity.*;
import model.entity.Access;
import model.entity.Producto;
import model.entity.Proforma;
import model.entity.Resource;
import model.entity.User;  
@SuppressWarnings("serial")
 
public class AddController extends HttpServlet {  
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)   
	         throws ServletException, IOException {
		
		doPost(request,response);
		
	}
	    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
		com.google.appengine.api.users.User uGoogle =UserServiceFactory.getUserService().getCurrentUser();
		if(uGoogle==null){
			RequestDispatcher dp= getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/error.jsp");
			dp.forward(request, response);
		}
		else{
			PersistenceManager accesoControlador=PMF.get().getPersistenceManager();
			String qUsers="select from "+ User.class.getName()+" where email=='"+uGoogle.getEmail()+"' && status==true";
			List<User> uSearch=(List<User>) accesoControlador.newQuery(qUsers).execute();
			if(uSearch.isEmpty()){	
				RequestDispatcher dp= getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/error2.jsp");
				dp.forward(request, response);
			}else{
				String query2="select from "+ Resource.class.getName()
						+" where url == '"+request.getServletPath()+"' && status==true";
				List <Resource> rSearch=(List<Resource>) accesoControlador.newQuery(query2).execute();
				if(rSearch.isEmpty()){
					RequestDispatcher dp= getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/error3.jsp");
					dp.forward(request, response);
				}
				else{
					String query3 = "select from "+Access.class.getName()
							+" where idRole == "+uSearch.get(0).getIdRole()+" && idUrl== "+rSearch.get(0).getId()+" && status==true";	
							List <Access> aSearch=(List<Access>) accesoControlador.newQuery(query3).execute();		
				if(aSearch.isEmpty()){
					RequestDispatcher dp= getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/error4.jsp");
					dp.forward(request, response);
				}else{
					accesoControlador.close();
					
		boolean existe = false;
		String res = request.getParameter("name");
		if(res!=null){ 
		
			
		String name=request.getParameter("name");  
        String direc=request.getParameter("direccion");
        String telefono=request.getParameter("telefono");
        int cant=Integer.parseInt(request.getParameter("cantidad"));
        
        
        Producto unico= new Producto("Mesa",15.0);
        double pTotal=cant*unico.getpPrecio();
        
        PersistenceManager pm = PMF.get().getPersistenceManager();

		String query = "select  from " + Proforma.class.getName();
		List<Proforma> listas = (List<Proforma>) pm.newQuery(query).execute();
        
		
		
		for(Proforma c : listas){
			if(c.getName().equals(name))
				existe=true;
		}
		
		if(!existe){
		Proforma nuevo= new Proforma(name, direc, telefono, cant);  
        nuevo.settPrecio(pTotal);
        nuevo.setIGV(0.18*pTotal);
        

    	try{
			pm.makePersistent(nuevo);
			response.sendRedirect("/proformas/view");
			
		}
		finally {
			pm.close();
		}
	

	}
		else {
			request.setAttribute("existe", existe);
			request.getRequestDispatcher("/WEB-INF/Views/proformas/add.jsp").forward(request, response);
			}
		}
		else {
			request.setAttribute("existe", existe);
			request.getRequestDispatcher("/WEB-INF/Views/proformas/add.jsp").forward(request, response);
			
		}
	}

				}
			}
		}
	}
}