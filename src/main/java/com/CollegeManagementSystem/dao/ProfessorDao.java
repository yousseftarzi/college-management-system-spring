package com.CollegeManagementSystem.dao;

import com.CollegeManagementSystem.model.Course;
import com.CollegeManagementSystem.model.Professor;
import com.CollegeManagementSystem.model.SchoolClass;

public interface ProfessorDao extends GenericDAO{

	Professor findByEmail(String email);
	void assignCourse(Professor professor, Course course);
	void unassignCourse(Professor professor, Course course);
	void assignSchoolClass(Professor professor,SchoolClass classe);
	void unassignSchoolClass(Professor professor, SchoolClass classe);
	
}
