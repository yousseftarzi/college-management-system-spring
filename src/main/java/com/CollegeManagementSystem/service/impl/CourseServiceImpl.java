package com.CollegeManagementSystem.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CollegeManagementSystem.dao.CourseDao;
import com.CollegeManagementSystem.model.Course;
import com.CollegeManagementSystem.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseDao courseDao;
	
	@Override
	@Transactional
	public void save(Course course) throws Exception {
		// TODO Auto-generated method stub
		courseDao.save(course);
	}

	@Override
	@Transactional
	public void delete(int id) throws Exception {
		// TODO Auto-generated method stub
		Course course = (Course) courseDao.find(Course.class, id);
		courseDao.delete(course);
	}

	@Override
	@Transactional
	public Course find(int id) throws Exception {
		// TODO Auto-generated method stub
		Course course = (Course) courseDao.find(Course.class, id);
		Hibernate.initialize(course.getGrade());
		return course;
	}

	@Override
	@Transactional
	public List<Course> findAll() throws Exception {
		// TODO Auto-generated method stub
		return courseDao.findAll(Course.class);
	}

	
}
