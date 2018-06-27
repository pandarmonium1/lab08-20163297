package controller.roles;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import pmf.entity.*;
import model.entity.Role;

public class RolesControllerDelete extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
		Key k =	KeyFactory.createKey(Role.class.getSimpleName(), new Long(request.getParameter("id")).longValue());
		Role r = persistenceManager.getObjectById(Role.class, k);
		
		persistenceManager.deletePersistent(r);
		response.sendRedirect("/roles");
	}
	
}
