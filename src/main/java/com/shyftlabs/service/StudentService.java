package com.shyftlabs.service;

import java.util.List;

import com.shyftlabs.model.Student;

public interface StudentService {

	boolean addNewStudent(Student student);
	
	List<Student> getAllStudents();
	
	boolean deleteStudent(long studentId);

}
