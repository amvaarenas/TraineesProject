package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Course;
import com.example.demo.entities.Teacher;
import com.example.demo.service.TeacherService;


@RestController
public class TeacherController {
	@Autowired
	TeacherService teacherService;
	
	@GetMapping("/teacher")
	public ResponseEntity<List<Teacher>> getTeacher() {
		return new ResponseEntity<List<Teacher>>(teacherService.getTeacher(), HttpStatus.OK);
	}
	
	@PostMapping("/teacher")
	public ResponseEntity<Teacher> postTeacher(@RequestBody Teacher teacher) {
		return new ResponseEntity<Teacher>(teacherService.postTeacher(teacher), HttpStatus.OK);
	}
	
	@GetMapping("/teacher/{id}/courses")
	public ResponseEntity<List<Course>> getCourses(@PathVariable int id) {
		return new ResponseEntity<List<Course>>(teacherService.getCourses(id), HttpStatus.OK);
	}
	@PostMapping("/teacher/{id}/courses")
	public ResponseEntity<List<Course>> postCourses(@RequestBody List<Course>courses) {
		return new ResponseEntity<List<Course>>(teacherService.insertCourse(courses), HttpStatus.OK);
	}
}
