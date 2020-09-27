package com.la.web.CourseController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.la.dao.CourseDao;
import com.la.dao.CourseDaoImpl;
import com.la.dao.StandardDao;
import com.la.dao.StandardDaoImpl;
import com.la.dao.TeacherDao;
import com.la.dao.TeacherDaoImpl;
import com.la.model.Course;
import com.la.model.Standard;
import com.la.model.Teacher;

/**
 * Servlet implementation class UpdateCourse
 */
@WebServlet("/update-subject")
public class UpdateCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private TeacherDao teacherDao;
	private CourseDao courseDao;
   	private StandardDao standardDao;

	public void init() {
		courseDao = new CourseDaoImpl();
		teacherDao = new TeacherDaoImpl();
		standardDao = new StandardDaoImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				try {
					updateCourse(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}

	}
	private void updateCourse(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, NumberFormatException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		try{

		String couName = request.getParameter("name");
		
		int std=Integer.parseInt(request.getParameter("cid"));
		int couId=Integer.parseInt(request.getParameter("id"));
		int empId=Integer.parseInt(request.getParameter("id"));
		
		
		System.out.println(std+" "+" "+couId);
		Course updateCourse = new Course(couId, couName);
		
		Standard updateStandard=new Standard();
		updateStandard.setStdNo(std);
			
		Set<Standard> standardlist=new HashSet<>();
		standardlist.add(updateStandard);
		
		updateCourse.setStd(standardlist);
		
		Teacher updateTeacher=new Teacher();
		updateTeacher.setEmpNo(empId);
		
		List<Teacher> teacherlist=new ArrayList<Teacher>();
		teacherlist.add(updateTeacher);
		
		updateCourse.setTeacher(teacherlist);
		
		
		standardDao.updateStandard(updateStandard);
		courseDao.updateCourse(updateCourse);
		teacherDao.updateTeacher(updateTeacher);
		response.sendRedirect("list-subject");
		}catch(Exception e){
			out.print("<h2><center>Please enter valid data</center></h2>");
		}
}
}
