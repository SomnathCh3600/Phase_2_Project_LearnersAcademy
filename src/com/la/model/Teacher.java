package com.la.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="Teacher")
public class Teacher {
	
	@Id
	@Column (name="Emp_id", nullable=false)
	private int empNo;
	
	@Column (name="First_Name")
	private String firstName;
	
	@Column (name="Last_Name")
	private String lastName;
	
	@Column (name="email")
	private String email;
	
	@Column (name="Designation")
	private String designation;
	
	@OneToMany(fetch=FetchType.LAZY , 
			cascade={CascadeType.DETACH,CascadeType.MERGE,
					CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="Course_ID")
	private List<Course> course;
	
	public Teacher(){}
		
	public Teacher(String firstName, String lastName, String email, String designation) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.designation = designation;

	}

	public Teacher(int empNo, String firstName, String lastName, String email, String designation) {
		super();
		this.empNo = empNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.designation = designation;

	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}
	
	
	@Override
	public String toString() {
		return firstName+ " " + lastName;
	}
	

}
