package com.la.dao;

import java.sql.SQLException;
import java.util.List;

import com.la.model.Teacher;



public interface TeacherDao {
	
	void insertTeacher(Teacher teacher) throws SQLException;

	Teacher selectTeacher(int empId);

	List<Teacher> selectAllTeachers();

	void deleteTeacher(int empId) throws SQLException;

	void updateTeacher(Teacher teacher) throws SQLException;

}
