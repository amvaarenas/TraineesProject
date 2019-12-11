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

import com.example.demo.entities.Course;
import com.example.demo.service.CourseService;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;
    	
	@GetMapping("/course")
	public ResponseEntity<List<Course>> getCourses(){
		return new ResponseEntity<List<Course>>(courseService.getCourses(), HttpStatus.OK);
	}
	
	@PostMapping("/course")
	public ResponseEntity<Course> insertCourse(@RequestBody Course Course){
		return new ResponseEntity<Course>(courseService.insertCourse(Course), HttpStatus.OK);
	}
	
	@GetMapping("course/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable int id){
		Optional<Course> test = courseService.getCourseById(id);
		if(!test.isPresent()) {
			return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<Course>(test.get(), HttpStatus.OK);
		}
	}
	
	@DeleteMapping("course/{id}")
	public ResponseEntity<Course> deleteCourse(@PathVariable int id){
		Optional<Course> test = courseService.getCourseById(id);
		if(!test.isPresent()) {
			return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
		}
		else {
			courseService.deleteCourse(id);
			return new ResponseEntity<Course>(HttpStatus.OK);
		}
    }
  /*  
    @PostMapping("course/{idCourse}/addstudent/{idStuden}")
    public ResponseEntity<Course> addStudent(@PathVariable int idCourse,
                                            @PathVariable int idStudent){
        Optional<Course> opt = courseService.addStudent(idCourse, idStudent);

        return null;
    }
*/
}
