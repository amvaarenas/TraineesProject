package com.example.demo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

public class Course {
	@Column(name = "name")
	String name;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	int course_id;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Course_students", joinColumns = { @JoinColumn(name = "idC") }, inverseJoinColumns = {
			@JoinColumn(name = "idS") })
	List<Student> students;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return course_id;
	}

	public void setId(int id) {
		this.course_id = id;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
