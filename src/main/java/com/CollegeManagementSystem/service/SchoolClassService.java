package com.CollegeManagementSystem.service;

import java.util.List;

import com.CollegeManagementSystem.model.SchoolClass;

public interface SchoolClassService {

	void save(SchoolClass schoolClass) throws Exception;

	void delete(int id) throws Exception;

	SchoolClass find(int id) throws Exception;

	List<SchoolClass> findAll() throws Exception;

	String getSchoolClassName(String branchName, String level) throws Exception;


}
