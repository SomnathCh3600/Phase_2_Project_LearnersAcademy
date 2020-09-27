package com.la.web.StudentController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.la.dao.StudentDao;
import com.la.dao.StudentDaoImpl;

/**
 * Servlet implementation class DeleteStudent
 */
@WebServlet("/delete")
public class DeleteStudent extends HttpServlet {
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
				try {
					deleteStudent(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}

	}
	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		studentDao.deleteStudent(id);
		response.sendRedirect("student");
	}
}
