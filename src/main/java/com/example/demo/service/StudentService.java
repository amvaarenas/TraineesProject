package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CourseRepository;
import com.example.demo.dao.StudentRepository;
import com.example.demo.entities.Course;
import com.example.demo.entities.Student;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	public List<Student> getStudents(){
		return studentRepository.findAll();
	}
	
	@Transactional
	public Optional<Student> getStudentById(Integer id) {
		return studentRepository.findById(id);
	}
	
	public Student insertStudent(Student student) {
		List<Course> cList = student.getCourses();
		for(Course c : cList) {
			Optional<Course> opt = courseRepository.findById(c.getId());
			if(!opt.isPresent()) {
				courseRepository.save(c);
			}
		}
		return studentRepository.save(student);
	}
	
	public void deleteStudent(Integer id) {
		studentRepository.deleteById(id);
	}

}
