package com.la.web.StandardController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.la.dao.StandardDao;
import com.la.dao.StandardDaoImpl;
import com.la.model.Standard;


/**
 * Servlet implementation class EditStandard
 */
@WebServlet("/editstd")
public class EditStandard extends HttpServlet {
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


		try {showEditForm(request, response);
			} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Standard existingStandard = standardDao.selectStandard(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Standard/standard-form.jsp");
		request.setAttribute("Standard", existingStandard);
		dispatcher.forward(request, response);
	}
}
