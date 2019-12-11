package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dao.CourseRepository;
import com.example.demo.dao.StudentRepository;
import com.example.demo.entities.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
/**
 * CourseService
 */
public class CourseService {

    @Autowired
	StudentRepository studentRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	public List<Course> getCourses(){
		return courseRepository.findAll();
	}
	
	public Optional<Course> getCourseById(Integer id) {
		return courseRepository.findById(id);
	}
	@Transactional
	public Course insertCourse(Course course) {
		return courseRepository.save(course);
    }
    
    public Optional<Course> addStudent(int idCourse, int idStudent){
        Optional<Course> optCourse = courseRepository.findById(idCourse);
        Optional<Student> optStudent = studentRepository.findById(idStudent);
        if(optCourse.isPresent() && optStudent.isPresent()){
            optCourse.get().getStudents().add(optStudent.get());
        }
        return optCourse;
    }
	
	public void deleteCourse(Integer id) {
		courseRepository.deleteById(id);
	}
}

