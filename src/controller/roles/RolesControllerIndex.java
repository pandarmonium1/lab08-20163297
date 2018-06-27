package controller.roles;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pmf.entity.*;
import model.entity.Role;

public class RolesControllerIndex extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

		PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
		String query = "select from "+Role.class.getName()+ " where name != ''";
		List<Role> roles = (List<Role>) persistenceManager.newQuery(query).execute();
		request.setAttribute("roles", roles);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/Roles/index.jsp");
		dispatcher.forward(request, response);

	}

}
