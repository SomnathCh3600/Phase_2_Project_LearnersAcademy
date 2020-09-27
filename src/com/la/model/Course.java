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
import javax.persistence.Table;

@Entity
@Table (name="subject")
public class Course {
	
	@Id
	@Column (name="Course_ID")
	private int couNo;
	
	@Column (name="Name")
	private String name;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade={CascadeType.DETACH,CascadeType.MERGE,
			CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name="teacher_courses", joinColumns=@JoinColumn(name="Course_ID"),
	inverseJoinColumns=@JoinColumn(name="Emp_id"))
	private List<Teacher> teacher;

	
	
	@ManyToMany(fetch=FetchType.EAGER, cascade={CascadeType.DETACH,CascadeType.MERGE,
			CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name="standard_courses", joinColumns=@JoinColumn(name="Course_ID"),
	inverseJoinColumns=@JoinColumn(name="Std_id"))
	private Set<Standard> std;

	public Course(){}

	public Course(String name) {
		super();
		this.name = name;
	}

	public Course(int couNo, String name) {
		super();
		this.couNo = couNo;
		this.name = name;
	}

	public int getCouNo() {
		return couNo;
	}

	public void setCouNo(int couNo) {
		this.couNo = couNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Standard> getStd() {
		return std;
	}

	public void setStd(Set<Standard> std) {
		this.std = std;
	}

	public List<Teacher> getTeacher() {
		return teacher;
	}

	public void setTeacher(List<Teacher> teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		String fname=null;
		String lname=null;

		for(Teacher name: teacher){
			
			 fname=name.getFirstName();
			 lname=name.getLastName();
			
		}
		
		return getName() + ": teacher="+ fname+" "+lname;
	}


}