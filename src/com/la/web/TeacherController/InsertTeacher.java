package com.la.web.TeacherController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.la.dao.TeacherDao;
import com.la.dao.TeacherDaoImpl;
import com.la.model.Teacher;


@WebServlet("/insert-teacher")
public class InsertTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
  	private TeacherDao teacherDao;
   	

	public void init() {
		teacherDao = new TeacherDaoImpl();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				try {
					insertTeacher(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	}
	private void insertTeacher(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String email = request.getParameter("email");
		String desig = request.getParameter("desig");
		
		Teacher newTeacher = new Teacher(id, firstName, lastName, email, desig);
		teacherDao.insertTeacher(newTeacher);
		
		response.sendRedirect("list-teacher");
	}
}
