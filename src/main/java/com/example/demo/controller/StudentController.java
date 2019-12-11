package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/student")
	public ResponseEntity<List<Student>> getStudents(){
		return new ResponseEntity<List<Student>>(studentService.getStudents(), HttpStatus.OK);
	}
	
	@PostMapping("/student")
	public ResponseEntity<Integer> insertStudent(@RequestBody Student student){
		return new ResponseEntity<Integer>(studentService.insertStudent(student).getId(), HttpStatus.OK);
	}
	
	@GetMapping("student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable int id){
		Optional<Student> test = studentService.getStudentById(id);
		if(!test.isPresent()) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<Student>(test.get(), HttpStatus.OK);
		}
	}
	
	@DeleteMapping("student/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable int id){
		Optional<Student> test = studentService.getStudentById(id);
		if(!test.isPresent()) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		else {
			studentService.deleteStudent(id);
			return new ResponseEntity<Student>(HttpStatus.OK);
		}
	}

}
