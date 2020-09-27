package com.la.web.CourseController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.la.dao.CourseDao;
import com.la.dao.CourseDaoImpl;

@WebServlet("/delete-subject")
public class DeleteCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private CourseDao courseDao;

	public void init() {
		courseDao = new CourseDaoImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		try {deleteCourse(request, response);
			} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	private void deleteCourse(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		courseDao.deleteCourse(id);
		response.sendRedirect("list-subject");
	}
}
