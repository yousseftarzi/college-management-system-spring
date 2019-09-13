package com.CollegeManagementSystem.service;

import java.util.List;

import com.CollegeManagementSystem.model.Branch;
import com.CollegeManagementSystem.model.Grade;

public interface GradeService {

	int save(Grade grade) throws Exception;
	List<Grade> findAll() throws Exception;
	Grade find(int id) throws Exception;
	void delete(int id) throws Exception;
	Grade findByLevelandBranch(String level, Branch branch);
}
