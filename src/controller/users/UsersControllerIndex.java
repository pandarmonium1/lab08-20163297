package controller.users;

import java.io.IOException;
import java.io.PrintWriter;


import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entity.User;
import pmf.entity.*;

public class UsersControllerIndex extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
		String query = "select from "+User.class.getName();
		List<User> users = (List<User>) persistenceManager.newQuery(query).execute();
		request.setAttribute("users", users);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/Users/index.jsp");
		dispatcher.forward(request, response);
		persistenceManager.close();
	}
	
}
