package controller.proform;
import java.util.*;
import pmf.entity.*;
import java.io.IOException;  
import java.io.PrintWriter;

import javax.jdo.PersistenceManager;
import javax.jws.WebService;
import javax.servlet.*;  
import javax.servlet.http.*;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.users.UserServiceFactory;

import model.entity.Access;
import model.entity.Producto;
import model.entity.Proforma;
import model.entity.Resource;
import model.entity.User;  
@SuppressWarnings("serial")
public class UpdateController extends HttpServlet {  
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)   
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
		
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Key k = KeyFactory.createKey(Proforma.class.getSimpleName(), new Long(request.getParameter("proformaId")).longValue());
		Proforma r = pm.getObjectById(Proforma.class, k);
		
		request.setAttribute("proformas", r);
		
		request.getRequestDispatcher("/WEB-INF/Views/proformas/update.jsp").forward(request, response);
		pm.close();
				}
				}
			}
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
		
	        String name=request.getParameter("name");  
	        String direc=request.getParameter("direccion");
	        String telefono=request.getParameter("telefono");
	        int cant=Integer.parseInt(request.getParameter("cantidad"));
	         
	        Producto unico= new Producto("Mesa",15.0);
	        
	        double pTotal=cant*unico.getpPrecio();
	        
	       
			PersistenceManager pm = PMF.get().getPersistenceManager();
			Key k = KeyFactory.createKey(Proforma.class.getSimpleName(), new Long(request.getParameter("proformaId")).longValue());
			Proforma r = pm.getObjectById(Proforma.class, k);
	
			
			r.setName(name);
			r.setDireccion(direc);
			r.setTelefono(telefono);
			r.setCant(cant);
			r.setDate(new Date());
			r.settPrecio(pTotal);
		response.sendRedirect("/proformas/view");
		pm.close();
}}
