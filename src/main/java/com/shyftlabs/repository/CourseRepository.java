package com.shyftlabs.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.shyftlabs.model.Course;

/**
 * 
 */

public interface CourseRepository extends CrudRepository<Course, Long>  {
	List<Course> findAll();

	Course findById(long courseId);
}
