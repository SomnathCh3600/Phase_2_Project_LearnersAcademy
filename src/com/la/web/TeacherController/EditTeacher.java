package com.la.web.TeacherController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.la.dao.TeacherDao;
import com.la.dao.TeacherDaoImpl;
import com.la.model.Teacher;

@WebServlet("/edit-teacher")
public class EditTeacher extends HttpServlet {
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


		try {showEditForm(request, response);
			} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Teacher existingTeacher = teacherDao.selectTeacher(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Teacher/teacher-form.jsp");
		request.setAttribute("Teacher", existingTeacher);
		dispatcher.forward(request, response);
	}
}
