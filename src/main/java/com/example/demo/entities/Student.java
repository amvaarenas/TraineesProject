package com.example.demo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	@Column
	String name;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int student_id;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
	name = "student_course",
	joinColumns = {@JoinColumn (name = "student_id")},
	inverseJoinColumns = {@JoinColumn (name = "course_id")}
	)
	List<Course> courses;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return student_id;
	}
	public void setId(int id) {
		this.student_id = id;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	

}
