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
 * Servlet implementation class InsertStudent
 */
@WebServlet("/insert")
public class InsertStudent extends HttpServlet {
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
					insertStudent(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	}
	private void insertStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String email = request.getParameter("email");
		Integer std=Integer.parseInt(request.getParameter("std"));
		Student newStudent = new Student(firstName, lastName, email);
		Standard newStandard=new Standard();
		newStandard.setStdNo(std);
		newStudent.setStandard(newStandard);
		studentDao.insertStudent(newStudent);
		standardDao.insertStandard(newStandard);
		response.sendRedirect("student");
	}
}
