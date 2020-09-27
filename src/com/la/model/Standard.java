package com.la.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table (name="Standard")
public class Standard {
	
	@Id
	@Column (name="Std_id", nullable=false)
	private int stdNo;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="standard" , 
			cascade={CascadeType.ALL})
	private Set<Student> student;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade={CascadeType.ALL})
	@JoinTable(name="standard_courses", joinColumns=@JoinColumn(name="Std_id"),
	inverseJoinColumns=@JoinColumn(name="Course_ID"))
	private Set<Course> course;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade={CascadeType.DETACH,CascadeType.MERGE,
			CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name="standard_teacher", joinColumns=@JoinColumn(name="Std_id"),
	inverseJoinColumns=@JoinColumn(name="Emp_id"))
	private List<Teacher> teacher;

	public Standard(){}
	
	

	public Standard(int stdNo) {
		this.stdNo = stdNo;
		
	}

	public int getStdNo() {
		return stdNo;
	}

	public void setStdNo(int stdNo) {
		this.stdNo = stdNo;
	}

	public Set<Student> getStudent() {
		return student;
	}

	public void setStudent(Set<Student> student) {
		this.student = student;
	}

	public Set<Course> getCourse() {
		return course;
	}

	public void setCourse(Set<Course> course) {
		this.course = course;
	}

	public List<Teacher> getTeacher() {
		return teacher;
	}

	public void setTeacher(List<Teacher> teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return stdNo+"";
	}


	

}
