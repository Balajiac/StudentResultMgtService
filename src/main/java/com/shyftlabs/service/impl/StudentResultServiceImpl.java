package com.shyftlabs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shyftlabs.model.StudentResult;
import com.shyftlabs.repository.StudentResultRepository;
import com.shyftlabs.service.StudentResultService;

@Service
public class StudentResultServiceImpl implements StudentResultService {

	@Autowired    
	private StudentResultRepository repository;  
	
	@Transactional
	public boolean addNewStudentResult(StudentResult studentResult) {
		return repository.save(studentResult) != null;
	}
	
	@Transactional
	public List<StudentResult> getAllStudentResults() {
		return repository.findAll();
	}
	

}
