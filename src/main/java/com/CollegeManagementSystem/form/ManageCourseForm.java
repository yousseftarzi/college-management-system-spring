package com.CollegeManagementSystem.form;

import com.CollegeManagementSystem.model.Course;
import com.CollegeManagementSystem.model.Professor;

public class ManageCourseForm {

	private Course course;
	private Professor professor;
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	
}
