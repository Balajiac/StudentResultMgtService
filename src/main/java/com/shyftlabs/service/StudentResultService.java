package com.shyftlabs.service;

import java.util.List;

import com.shyftlabs.model.StudentResult;

public interface StudentResultService {

	boolean addNewStudentResult(StudentResult studentResult);
	
	List<StudentResult> getAllStudentResults();

}
