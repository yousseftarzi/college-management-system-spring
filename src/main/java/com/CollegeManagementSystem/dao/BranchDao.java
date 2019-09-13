package com.CollegeManagementSystem.dao;

import com.CollegeManagementSystem.model.Branch;

public interface BranchDao extends GenericDAO {

	Branch findByName(String name);
}
