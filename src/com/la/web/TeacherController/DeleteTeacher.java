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



@WebServlet("/delete-teacher")
public class DeleteTeacher extends HttpServlet {
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
					deleteTeacher(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}

	}
	private void deleteTeacher(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		teacherDao.deleteTeacher(id);
		response.sendRedirect("list-teacher");
	}
}
