package controller.access;

import java.io.IOException;


import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.repackaged.org.joda.time.DateTimeZone;
import com.google.appengine.repackaged.org.joda.time.LocalDateTime;

import pmf.entity.*;
import model.entity.Access;

public class AccessControllerEdit extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Key k =	KeyFactory.createKey(Access.class.getSimpleName(), new Long(request.getParameter("id")).longValue());
		Access a = pm.getObjectById(Access.class, k);
		request.setAttribute("access", a);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/Access/edit.jsp");
		dispatcher.forward(request, response);
		pm.close();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String status = request.getParameter("status");
	
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Key k =	KeyFactory.createKey(Access.class.getSimpleName(), new Long(request.getParameter("id")).longValue());
		Access a = pm.getObjectById(Access.class, k);
		boolean prueba = false;
		if(status.equalsIgnoreCase("true")){
			prueba = true;
		}
		if(a.isStatus() != prueba){
			try {
				a.updateStatus(prueba);
			} finally {
				pm.close();
			}
		}
		response.sendRedirect("/access");
		pm.close();
	}
	
}
