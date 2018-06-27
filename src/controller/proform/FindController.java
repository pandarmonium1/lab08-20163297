package controller.proform;

import java.io.IOException;
import pmf.entity.*;

import javax.jdo.PersistenceManager;
import javax.servlet.*;  
import javax.servlet.http.*;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import model.entity.Proforma;  
@SuppressWarnings("serial")

public class FindController extends HttpServlet {  
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)   
	         throws ServletException, IOException {  

			PersistenceManager pm = PMF.get().getPersistenceManager();
			Key k = KeyFactory.createKey(Proforma.class.getSimpleName(), Long.parseLong(request.getParameter("proformaId")));
			Proforma r = pm.getObjectById(Proforma.class, k);
			request.setAttribute("proformas", r);
			request.getRequestDispatcher("/WEB-INF/Views/proformas/read.jsp").forward(request, response);
			pm.close();
			
		
		}
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response)   
	         throws ServletException, IOException {  
			doGet(request,response);
		     
		}
}
