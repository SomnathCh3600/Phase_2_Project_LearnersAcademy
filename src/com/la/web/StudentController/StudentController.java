package com.la.web.StudentController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.la.dao.StudentDao;
import com.la.dao.StudentDaoImpl;
import com.la.model.Student;




@WebServlet("/student")
public class StudentController extends HttpServlet {
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
    				listStudent(request, response);
    				
    			
    		} catch (SQLException ex) {
    			throw new ServletException(ex);
    		}
    	}

    	private void listStudent(HttpServletRequest request, HttpServletResponse response)
    			throws SQLException, IOException, ServletException {
    		List<Student> listStudent= studentDao.selectAllStudents();
    		request.setAttribute("listStudent", listStudent);
    		RequestDispatcher dispatcher = request.getRequestDispatcher("Student/Student_list.jsp");
    		dispatcher.forward(request, response);
    	}

    }
