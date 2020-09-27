package com.la.web.TeacherController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.la.dao.TeacherDao;
import com.la.dao.TeacherDaoImpl;
import com.la.model.Teacher;



@WebServlet("/list-teacher")
public class ListTeacher extends HttpServlet {
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
				listTeacher(request, response);
				
			
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listTeacher(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Teacher> listTeacher= teacherDao.selectAllTeachers();
		request.setAttribute("listTeacher", listTeacher);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Teacher/teacher-list.jsp");
		dispatcher.forward(request, response);
	}
}
