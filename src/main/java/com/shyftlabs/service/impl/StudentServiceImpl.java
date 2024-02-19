package com.shyftlabs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shyftlabs.model.Student;
import com.shyftlabs.repository.StudentRepository;
import com.shyftlabs.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired    
	private StudentRepository repository;  

	@Transactional
	public boolean addNewStudent(Student student) {
		return repository.save(student) != null;
	}
	
	@Transactional
	public List<Student> getAllStudents() {
		return repository.findAll();
	}
	
	@Transactional
	public boolean deleteStudent(long studentId) {
		repository.deleteById(studentId);
		return true;
	}

}
