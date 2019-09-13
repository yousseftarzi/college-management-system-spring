package com.CollegeManagementSystem.dao;

import com.CollegeManagementSystem.model.Branch;
import com.CollegeManagementSystem.model.Grade;

public interface GradeDao extends GenericDAO {

	Grade findByLevelandBranch(String level, Branch branch);

}
