package com.CollegeManagementSystem.service;

import java.util.List;

import com.CollegeManagementSystem.model.Course;

public interface CourseService {

	void save(Course course) throws Exception;

	void delete(int id) throws Exception;

	Course find(int id) throws Exception;

	List<Course> findAll() throws Exception;

}
