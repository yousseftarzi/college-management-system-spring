package com.CollegeManagementSystem.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CollegeManagementSystem.dao.GradeDao;
import com.CollegeManagementSystem.model.Branch;
import com.CollegeManagementSystem.model.Grade;
import com.CollegeManagementSystem.service.GradeService;

@Service
public class GradeServiceImpl implements GradeService{

	@Autowired
	private GradeDao gradeDao;

	@Override
	@Transactional
	public int save(Grade grade) throws Exception {
		// TODO Auto-generated method stub
		gradeDao.save(grade);
		return grade.getId();
	}

	@Override
	@Transactional
	public List<Grade> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<Grade> listGrade = gradeDao.findAll(Grade.class);
		for (Grade grade : listGrade) {
			Hibernate.initialize(grade.getBranch());
		}
		return  listGrade;
	}

	@Override
	@Transactional
	public Grade find(int id) throws Exception {
		// TODO Auto-generated method stub
		Grade grade= (Grade) gradeDao.find(Grade.class,id);
		Hibernate.initialize(grade.getBranch());
		return grade;
	}

	@Override
	@Transactional
	public void delete(int id) throws Exception {
		// TODO Auto-generated method stub
		Grade grade = new Grade();
		grade.setId(id);
		gradeDao.delete(grade);
	}

	@Override
	@Transactional
	public Grade findByLevelandBranch(String level,Branch branch){
		return gradeDao.findByLevelandBranch(level, branch);
	}
}
