package com.shyftlabs.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.shyftlabs.model.Student;

/**
 * 
 */

public interface StudentRepository extends CrudRepository<Student, Long>  {
	List<Student> findAll();

	Student findById(long studentId);
}
