package controller.access;

import java.io.IOException;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pmf.entity.*;
import model.entity.Access;

@SuppressWarnings("serial")
public class AccessControllerIndex extends HttpServlet {

public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
		String query = "select from "+Access.class.getName()+ " where idUrl != ''";
		List<Access> access = (List<Access>) persistenceManager.newQuery(query).execute();
		request.setAttribute("access", access);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/Access/index.jsp");
		dispatcher.forward(request, response);
		
	}
	
}
