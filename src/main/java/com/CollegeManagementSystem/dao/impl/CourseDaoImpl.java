package com.CollegeManagementSystem.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.CollegeManagementSystem.dao.CourseDao;

@Repository
public class CourseDaoImpl extends GenericDaoImpl implements CourseDao{

	@Autowired
	private SessionFactory sessionFactory;
	
}
