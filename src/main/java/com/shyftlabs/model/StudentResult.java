package com.shyftlabs.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

/**
 * 
 */
@Entity
public class StudentResult {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long resultId;
	
	@OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "studentId", referencedColumnName = "studentId")
	private Student student;
	
	@OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "courseId", referencedColumnName = "courseId")
	private Course course;
	
	private String score;
	
	public long getResultId() {
		return resultId;
	}
	public void setResultId(long resultId) {
		this.resultId = resultId;
	}
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	/*
	public long getStudentId() {
		return studentId;
	}
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	
	public long getCourseId() {
		return courseId;
	}
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}
	*/

}
