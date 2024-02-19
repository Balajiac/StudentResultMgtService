package com.shyftlabs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shyftlabs.model.Course;
import com.shyftlabs.repository.CourseRepository;
import com.shyftlabs.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired    
	private CourseRepository repository;  
	
	@Transactional
	public boolean addNewCourse(Course course) {
		return repository.save(course) != null;
	}
	
	@Transactional
	public List<Course> getAllCourses() {
		return repository.findAll();
	}
	
	@Transactional
	public boolean deleteCourse(long courseId) {
		repository.deleteById(courseId);
		return true;
	}

}
