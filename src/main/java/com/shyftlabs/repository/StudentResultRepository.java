package com.shyftlabs.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.shyftlabs.model.Student;
import com.shyftlabs.model.StudentResult;

/**
 * 
 */

public interface StudentResultRepository extends CrudRepository<StudentResult, Long>  {
	List<StudentResult> findAll();

	Student findById(long resultId);
}
