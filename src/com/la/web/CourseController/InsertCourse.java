package com.la.web.CourseController;

import java.io.IOException;
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



@WebServlet("/insert-subject")
public class InsertCourse extends HttpServlet {
	
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
					insertCourse(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}

	}
	private void insertCourse(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, NumberFormatException {
		int std=0;
		int couId=0;
		int empId=0;
		String couName = request.getParameter("name");
		try{
		std=Integer.parseInt(request.getParameter("cid"));
		couId=Integer.parseInt(request.getParameter("id"));
		empId=Integer.parseInt(request.getParameter("tid"));
		}
		catch(NumberFormatException e){
			System.out.println("An exception occured: "+e);
		}
		System.out.println(std+" "+" "+couId);
		Course newCourse = new Course();
		newCourse.setName(couName);
		newCourse.setCouNo(couId);
		
		Standard newStandard=new Standard();
		newStandard.setStdNo(std);
			
		Set<Standard> standardlist=new HashSet<>();
		standardlist.add(newStandard);
		
		newCourse.setStd(standardlist);
		
		Teacher newTeacher=new Teacher();
		newTeacher.setEmpNo(empId);
		
		List<Teacher> teacherlist=new ArrayList<Teacher>();
		teacherlist.add(newTeacher);
		
		newCourse.setTeacher(teacherlist);
		
		
		standardDao.insertStandard(newStandard);
		courseDao.insertCourse(newCourse);
		teacherDao.insertTeacher(newTeacher);
		response.sendRedirect("list-subject");
	
}
}
