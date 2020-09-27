package com.la.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	response.setContentType("text/html");
		PrintWriter out = response.getWriter();
    	
    	String userName= request.getParameter("user");
		String password= request.getParameter("psw");
    	
    	if(userName.equals("admin") && password.equals("admin123")){
    		response.sendRedirect("welcome.html");
    	
	}else {
		
		out.print("<h1><center>Sorry, Invalid credentials !</center><h1>");
		request.getRequestDispatcher("index.html").include(request, response);
	}

	}
}
