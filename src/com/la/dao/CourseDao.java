package com.la.dao;

import java.sql.SQLException;
import java.util.List;

import com.la.model.Course;



public interface CourseDao {
	
	void insertCourse(Course course) throws SQLException;

	Course selectCourse(int subId);

	List<Course> selectAllCourses();

	void deleteCourse(int subId) throws SQLException;

	void updateCourse(Course course) throws SQLException;

}
