package controller.roles;

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
import model.entity.Role;

public class RolesControllerAdd extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/Roles/add.jsp");
		dispatcher.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{

		PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
		String name = request.getParameter("name");
		Date now = LocalDateTime.now(DateTimeZone.forID("America/Lima")).toDate();
		Role newRole = new Role(name, now);
		try {
			persistenceManager.makePersistent(newRole);
		}catch(Exception e) {
			response.sendRedirect("/index.html");
		}
		finally {
			persistenceManager.close();
		}
		response.sendRedirect("/roles");

	}
	
}
