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


@WebServlet("/update-teacher")
public class UpdateTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeacherDao teacherDao;

	public void init() {
		teacherDao = new TeacherDaoImpl();
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NumberFormatException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NumberFormatException {
				try {
					updateTeacher(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}

	}
	private void updateTeacher(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id=0;
		try{
		 id= Integer.parseInt(request.getParameter("id"));
		}
		catch(NumberFormatException e){
			System.out.println("An exception was catch: "+e);
		}

		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String email = request.getParameter("email");
		String desig = request.getParameter("desig");
		System.out.println(id+" "+firstName+ " "+lastName+" "+desig+" "+email);
		Teacher updateTeacher = new Teacher(id, firstName, lastName, email, desig);
		teacherDao.updateTeacher(updateTeacher);
		response.sendRedirect("list-teacher");
	}
}
