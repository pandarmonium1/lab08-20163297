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

import model.entity.Producto;
import model.entity.Proforma;  
@SuppressWarnings("serial")
public class UpdateController extends HttpServlet {  
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)   
	         throws ServletException, IOException {  
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Key k = KeyFactory.createKey(Proforma.class.getSimpleName(), new Long(request.getParameter("proformaId")).longValue());
		Proforma r = pm.getObjectById(Proforma.class, k);
		
		request.setAttribute("proformas", r);
		
		request.getRequestDispatcher("/WEB-INF/Views/proformas/update.jsp").forward(request, response);
		pm.close();
		
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
