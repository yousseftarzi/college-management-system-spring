package com.CollegeManagementSystem.service;

import java.util.List;

import com.CollegeManagementSystem.model.Student;

public interface StudentService {

	void save(Student student);

	void update(Student student);

	void delete(Student student);
	
	Student findById(int id);

	List<Student> findAll();

}
