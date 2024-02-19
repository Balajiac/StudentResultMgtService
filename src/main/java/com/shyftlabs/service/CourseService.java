package com.shyftlabs.service;

import java.util.List;

import com.shyftlabs.model.Course;

public interface CourseService {

	boolean addNewCourse(Course course);
	
	List<Course> getAllCourses();
	
	boolean deleteCourse(long courseId);

}
