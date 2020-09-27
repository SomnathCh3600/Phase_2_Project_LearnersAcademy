package com.la.dao;

import java.sql.SQLException;
import java.util.List;

import com.la.model.Student;



public interface StudentDao {

	void insertStudent(Student Student) throws SQLException;

	Student selectStudent(int StudentId);

	List<Student> selectAllStudents();

	void deleteStudent(int id) throws SQLException;

	void updateStudent(Student Student) throws SQLException;
	
}
