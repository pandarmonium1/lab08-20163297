package controller.access;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import pmf.entity.*;
import model.entity.Access;

public class AccessControllerDelete extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
		Key k =	KeyFactory.createKey(Access.class.getSimpleName(), new Long(request.getParameter("id")).longValue());
		Access a = persistenceManager.getObjectById(Access.class, k);
		
		persistenceManager.deletePersistent(a);
		response.sendRedirect("/access");
	}
	
}
