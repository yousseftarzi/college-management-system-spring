package com.CollegeManagementSystem.service;

import java.util.List;

import com.CollegeManagementSystem.model.Assignment;

public interface AssignmentService {

	void save(Assignment assignment);

	void update(Assignment assignment);

	void delete(int id);

	List<Assignment> findByCourseId(int courseId);

	Assignment findById(int id);

}
