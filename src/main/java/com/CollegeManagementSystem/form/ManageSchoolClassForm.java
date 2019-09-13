package com.CollegeManagementSystem.form;

import com.CollegeManagementSystem.model.Professor;
import com.CollegeManagementSystem.model.SchoolClass;

public class ManageSchoolClassForm {

	private SchoolClass schoolClass;
	private Professor professor;
	
	public SchoolClass getSchoolClass() {
		return schoolClass;
	}
	public void setSchoolClass(SchoolClass schoolClass) {
		this.schoolClass = schoolClass;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
}
