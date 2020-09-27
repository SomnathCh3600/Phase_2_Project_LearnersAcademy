package com.la.web.StudentController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class NewStudent
 */
@WebServlet("/new")
public class NewStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			showNewForm(request, response);
	}
	
		private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    			throws ServletException, IOException {
    		RequestDispatcher dispatcher = request.getRequestDispatcher("Student/student_form.jsp");
    		dispatcher.forward(request, response);
    	
	}
}
