package controller.resources;

import java.io.IOException;
import java.util.Date;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.repackaged.org.joda.time.DateTimeZone;
import com.google.appengine.repackaged.org.joda.time.LocalDateTime;

import pmf.entity.*;
import model.entity.Resource;

public class ResourcesControllerAdd extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/Resources/add.jsp");
		dispatcher.forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{

		PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
		String url = request.getParameter("url");
		Date now = LocalDateTime.now(DateTimeZone.forID("America/Lima")).toDate();
		Resource newResource = new Resource(url, now);
		try {
			persistenceManager.makePersistent(newResource);
		}catch(Exception e) {
			response.sendRedirect("/index.html");
		}
		finally {
			persistenceManager.close();
		}
		response.sendRedirect("/resources");

	}

}
