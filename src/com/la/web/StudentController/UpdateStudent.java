package com.la.web.StudentController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.la.dao.StandardDao;
import com.la.dao.StandardDaoImpl;
import com.la.dao.StudentDao;
import com.la.dao.StudentDaoImpl;
import com.la.model.Standard;
import com.la.model.Student;

/**
 * Servlet implementation class UpdateStudent
 */
@WebServlet("/update")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDao studentDao;
   	private StandardDao standardDao;

	public void init() {
		studentDao = new StudentDaoImpl();
		standardDao = new StandardDaoImpl();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				try {
					updateStudent(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}

	}
	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		Integer std=Integer.parseInt(request.getParameter("std"));
		Student updateStudent = new Student(id, fname, lname, email);
		Standard updateStandard=new Standard();
		updateStandard.setStdNo(std);
		updateStudent.setStandard(updateStandard);
		studentDao.updateStudent(updateStudent);
		standardDao.updateStandard(updateStandard);
		response.sendRedirect("student");
	}
}
