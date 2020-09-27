package com.la.web.StandardController;

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



import com.la.dao.StandardDao;
import com.la.dao.StandardDaoImpl;
import com.la.dao.StudentDao;
import com.la.dao.StudentDaoImpl;
import com.la.dao.TeacherDao;
import com.la.dao.TeacherDaoImpl;

import com.la.model.Standard;
import com.la.model.Student;
import com.la.model.Teacher;

/**
 * Servlet implementation class UpdateStandard
 */
@WebServlet("/updateStd")
public class UpdateStandard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDao studentDao;
   	private StandardDao standardDao;
   	private TeacherDao teacherDao;

	public void init() {
		studentDao = new StudentDaoImpl();
		standardDao = new StandardDaoImpl();
		teacherDao = new TeacherDaoImpl();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				try {
					updateStudent(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}

	}
	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		//int id = Integer.parseInt(request.getParameter("id"));

		int classId = Integer.parseInt(request.getParameter("id"));
		int stuId = Integer.parseInt(request.getParameter("sid"));
		int teaId = Integer.parseInt(request.getParameter("tid"));

		Teacher updateTeacher = new Teacher();
		updateTeacher.setEmpNo(teaId);
		
		Student updateStudent = new Student();
		updateStudent.setRollNo(stuId);
		
		Standard updateStandard=new Standard();
		updateStandard.setStdNo(classId);
		
		
		List<Teacher>teacherlist=new ArrayList<Teacher>();
		teacherlist.set(classId, updateTeacher);
		
		Set<Student>studentlist=new HashSet<>();
		studentlist.add(updateStudent);
		
		studentDao.updateStudent(updateStudent);
		teacherDao.updateTeacher(updateTeacher);
		standardDao.updateStandard(updateStandard);
		response.sendRedirect("list");
	}
}
