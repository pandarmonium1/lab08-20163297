package controller.users;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import pmf.entity.*;
import model.entity.User;

public class UsersControllerDelete extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
		Key k =	KeyFactory.createKey(User.class.getSimpleName(), new Long(request.getParameter("id")).longValue());
		User u = persistenceManager.getObjectById(User.class, k);
		
		persistenceManager.deletePersistent(u);
		response.sendRedirect("/users");
	}
	
}
