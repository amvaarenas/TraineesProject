package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CourseRepository;
import com.example.demo.dao.TeacherRepository;
import com.example.demo.entities.Course;
import com.example.demo.entities.Teacher;

@Service
public class TeacherService {
	@Autowired
	TeacherRepository teacherRepository;
	@Autowired
	CourseRepository courseRepository;

	public List<Teacher> getTeacher() {
		return teacherRepository.findAll();
	}

	@Transactional
	public List<Course> insertCourse(List<Course> courses) {
		for (Course course : courses) {
			Optional<Course> optional = courseRepository.findById(course.getId());
			if (!optional.isPresent()) {
				courseRepository.save(course);
			}

		}
		return courseRepository.findAll();
	}

	public void delete(int id) {
		courseRepository.deleteById(id);
	}
	@Transactional
	public Teacher postTeacher(Teacher teacher) {
		return teacherRepository.save(teacher);
	}

	public List<Course> getCourses(int id) {
		Optional<Teacher> teacher = teacherRepository.findById(id);
		if (teacher.isPresent()) {
			return teacher.get().getCourse();
		}
		return null;
	}
}
