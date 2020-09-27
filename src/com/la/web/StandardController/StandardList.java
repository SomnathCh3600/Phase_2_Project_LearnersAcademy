package com.la.web.StandardController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.la.dao.StandardDao;
import com.la.dao.StandardDaoImpl;
import com.la.model.Standard;



@WebServlet("/list")
public class StandardList extends HttpServlet {
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
				listStandard(request, response);
				
			
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listStandard(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Standard> listStandard= standardDao.selectAllStandards();
		request.setAttribute("listStandard", listStandard);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Standard/standard-list.jsp");
		dispatcher.forward(request, response);
	}
}
