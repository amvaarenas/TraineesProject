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
@Table(name = "teacher")
public class Teacher {
	@Column(name = "name")
	String name;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	int teacher_id;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Cursos_teacher", joinColumns = {
			@JoinColumn(name = "idC") }, inverseJoinColumns = { @JoinColumn(name = "idT") })
	List<Course> course;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return teacher_id;
	}

	public void setId(int id) {
		this.teacher_id = id;
	}

	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}
}
