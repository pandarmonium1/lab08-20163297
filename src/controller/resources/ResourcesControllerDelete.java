package controller.resources;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import pmf.entity.*;
import model.entity.Resource;

public class ResourcesControllerDelete extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
		Key k =	KeyFactory.createKey(Resource.class.getSimpleName(), new Long(request.getParameter("id")).longValue());
		Resource r = persistenceManager.getObjectById(Resource.class, k);
		
		persistenceManager.deletePersistent(r);
		response.sendRedirect("/resources");
	}
	
}
