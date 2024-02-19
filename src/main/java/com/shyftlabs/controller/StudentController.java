package com.shyftlabs.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shyftlabs.constants.ErrorConstants;
import com.shyftlabs.exception.ConstraintViolationException;
import com.shyftlabs.model.Student;
import com.shyftlabs.model.StudentResult;
import com.shyftlabs.service.StudentResultService;
import com.shyftlabs.service.StudentService;

@RestController
@RequestMapping(value  = "/students")
public class StudentController {

	@Autowired
	private StudentService studService;

	@Autowired
	private StudentResultService studResultService;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Student> getAllStudents() {
		return studService.getAllStudents();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public boolean addNewStudent(@RequestBody Student student) {
		return studService.addNewStudent(student);
	}

	@RequestMapping(value  = "/{studentId}", method = RequestMethod.DELETE)
	@ResponseBody
	public boolean deleteStudent(@PathVariable long studentId) {
		return studService.deleteStudent(studentId);
	}
	

	@RequestMapping(value  = "/results", method = RequestMethod.POST)
	@ResponseBody
	public boolean addNewStudentResult(@RequestBody StudentResult studentResult) throws ConstraintViolationException {
		try {
			return studResultService.addNewStudentResult(studentResult);
		} catch(Exception ex) {
			if(ex instanceof SQLIntegrityConstraintViolationException) {
				throw new ConstraintViolationException(ErrorConstants.STUD_RESULT_CONSTAINT_ERROR, ex);
			}
			if(ex instanceof DataIntegrityViolationException) {
				throw new ConstraintViolationException(ErrorConstants.STUD_RESULT_CONSTAINT_ERROR, ex);
			}
			throw ex;
		}
	}
	
	@RequestMapping(value  = "/results", method = RequestMethod.GET)
	@ResponseBody
	public List<StudentResult> getAllStudentResults() {
		return studResultService.getAllStudentResults();
	}
}
