package controller.access;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.repackaged.org.joda.time.DateTimeZone;
import com.google.appengine.repackaged.org.joda.time.LocalDateTime;

import pmf.entity.*;
import model.entity.*;

public class AccessControllerAdd extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		String qRol = "select from "+Role.class.getName()+ " where name != ''";
		List<Role> roles = (List<Role>) pm.newQuery(qRol).execute();
		request.setAttribute("roles", roles);
		
		PersistenceManager pm2 = PMF.get().getPersistenceManager();
		String qReso = "select from "+Resource.class.getName()+ " where url != ''";
		List<Resource> resources = (List<Resource>) pm2.newQuery(qReso).execute();
		request.setAttribute("resources", resources);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/Access/add.jsp");
		dispatcher.forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{

		PersistenceManager pm = PMF.get().getPersistenceManager();
		String idRole = request.getParameter("idRole");
		String idUrl = request.getParameter("idUrl");
		Date now = LocalDateTime.now(DateTimeZone.forID("America/Lima")).toDate();
		Access newAccess = new Access(Long.parseLong(idRole), Long.parseLong(idUrl), now);
		try {
			pm.makePersistent(newAccess);
		}catch(Exception e) {
			response.sendRedirect("/index.html");
		}
		finally {
			pm.close();
		}
		response.sendRedirect("/access");

	}
	
}
