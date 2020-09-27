package com.la.web.StudentController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.la.dao.StudentDao;
import com.la.dao.StudentDaoImpl;
import com.la.model.Student;

/**
 * Servlet implementation class EditStudent
 */
@WebServlet("/edit")
public class EditStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
   	private StudentDao studentDao;

	public void init() {
		studentDao = new StudentDaoImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		try {showEditForm(request, response);
			} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Student existingStudent = studentDao.selectStudent(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Student/student_form.jsp");
		request.setAttribute("Student", existingStudent);
		dispatcher.forward(request, response);
	}
}
