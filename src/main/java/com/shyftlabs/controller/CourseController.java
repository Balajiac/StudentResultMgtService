package com.shyftlabs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shyftlabs.model.Course;
import com.shyftlabs.service.CourseService;

@RestController
@RequestMapping(value  = "/courses")
public class CourseController {

	@Autowired
	private CourseService service;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Course> getAllCourses() {
		return service.getAllCourses();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public boolean addNewCourse(@RequestBody Course course) {
		return service.addNewCourse(course);
	}

	@RequestMapping(value  = "/{courseId}", method = RequestMethod.DELETE)
	@ResponseBody
	public boolean deleteCourse(@PathVariable long courseId) {
		return service.deleteCourse(courseId);
	}
}
