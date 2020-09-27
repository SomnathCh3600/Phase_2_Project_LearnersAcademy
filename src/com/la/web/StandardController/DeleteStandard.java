package com.la.web.StandardController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.la.dao.StandardDao;
import com.la.dao.StandardDaoImpl;



@WebServlet("/deletestd")
public class DeleteStandard extends HttpServlet {
	private static final long serialVersionUID = 1L;
   	private StandardDao standardDao;

	public void init() {
		standardDao = new StandardDaoImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				try {
					deleteStandard(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}

	}
	private void deleteStandard(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		standardDao.deleteStandard(id);
		response.sendRedirect("list");
	}
}
