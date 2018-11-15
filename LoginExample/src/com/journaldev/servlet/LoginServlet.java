package com.journaldev.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(
		description = "Login Servlet", 
		urlPatterns = { "/LoginServlet" }, 
		initParams = { 
				@WebInitParam(name = "user", value = "Pankaj"), 
				@WebInitParam(name = "password", value = "journaldev")
		})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		//get servlet config init params
		String userID = "admin";
		String password = "admin";
		//logging example
		
		
		if(userID.equals("admin") && password.equals("admin")){
			response.sendRedirect("LoginSuccess.jsp");
		}else{
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
			PrintWriter out= response.getWriter();
			out.println("<font color=red>Either user name or password is wrong.</font>");
			rd.include(request, response);
			
		}
		
	}

}
