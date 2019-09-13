package com.CollegeManagementSystem.service;

import java.util.List;

import com.CollegeManagementSystem.model.Course;
import com.CollegeManagementSystem.model.Professor;

public interface ProfessorService {

	int save(Professor professor) throws Exception;
	List<Professor> findAll() throws Exception;
	Professor find(int id) throws Exception;
	int delete(int id) throws Exception;
	Professor findByEmail(String email);
	void assignCourse(int idProfessor, int idCourse) throws Exception;
	void unassignCourse(int idProfessor, int idCourse) throws Exception;
	void assignSchoolClass(int idProfessor, int idSchoolClass) throws Exception;
	void unassignSchoolClass(int idProfessor, int idSchoolClass) throws Exception;
}
