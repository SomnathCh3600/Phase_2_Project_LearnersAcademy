package com.la.web.CourseController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.la.dao.CourseDao;
import com.la.dao.CourseDaoImpl;
import com.la.model.Course;


@WebServlet("/list-subject")
public class ListCourse extends HttpServlet {
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
		

		try {
				listCourse(request, response);
				
			
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listCourse(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Course> listCourse= courseDao.selectAllCourses();
		request.setAttribute("listCourse", listCourse);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Course/course-list.jsp");
		dispatcher.forward(request, response);
	}
}