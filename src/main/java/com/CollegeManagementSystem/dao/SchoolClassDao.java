package com.CollegeManagementSystem.dao;

public interface SchoolClassDao extends GenericDAO {

	int findNumber(String level, String branchName);

}
