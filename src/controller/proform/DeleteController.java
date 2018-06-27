package controller.proform;

import java.io.IOException;  

import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;

import javax.servlet.*;  
import javax.servlet.http.*;
import pmf.entity.*;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import model.entity.Proforma;  
@SuppressWarnings("serial")
public class DeleteController extends HttpServlet {  
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PersistenceManager pm = PMF.get().getPersistenceManager();
	Key k = KeyFactory.createKey(Proforma.class.getSimpleName(), new Long(request.getParameter("proformaId")).longValue());
	try{
		Proforma r = pm.getObjectById(Proforma.class, k);
		if (r !=null){
			Long id = r.getId();
			pm.deletePersistent(r);
			
			response.sendRedirect("/proformas/view");
			pm.close();
		}
	}catch (JDOObjectNotFoundException e) {
		response.sendRedirect("/proformas/view");
	}

}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
doGet(request,response);	
}
}
