package com.CollegeManagementSystem.service;

import java.util.List;

import com.CollegeManagementSystem.model.Branch;

public interface BranchService {

	int save(Branch branch) throws Exception;
	List<Branch> findAll() throws Exception;
	Branch find(int id) throws Exception;
	int delete(int id) throws Exception;
	Branch findByName(String name);
}
