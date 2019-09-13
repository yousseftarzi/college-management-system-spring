package com.CollegeManagementSystem.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CollegeManagementSystem.dao.GradeDao;
import com.CollegeManagementSystem.dao.SchoolClassDao;
import com.CollegeManagementSystem.model.SchoolClass;
import com.CollegeManagementSystem.service.SchoolClassService;

@Service
public class SchoolClassServiceImpl implements SchoolClassService{

	@Autowired
	private SchoolClassDao schoolClassDao;
	
	@Autowired
	private GradeDao gradeDao;
	
	@Override
	@Transactional
	public void save(SchoolClass schoolClass) throws Exception {
		// TODO Auto-generated method stub
		schoolClassDao.save(schoolClass);
	}

	@Override
	@Transactional
	public void delete(int id) throws Exception {
		// TODO Auto-generated method stub
		SchoolClass schoolClass = (SchoolClass) schoolClassDao.find(SchoolClass.class, id);
		schoolClassDao.delete(schoolClass);
	}

	@Override
	@Transactional
	public SchoolClass find(int id) throws Exception {
		// TODO Auto-generated method stub
		SchoolClass schoolClass = (SchoolClass) schoolClassDao.find(SchoolClass .class, id);
		Hibernate.initialize(schoolClass.getGrade());
		Hibernate.initialize(schoolClass.getStudents());
		return schoolClass;
	}

	@Override
	@Transactional
	public List<SchoolClass> findAll() throws Exception {
		// TODO Auto-generated method stub
		return schoolClassDao.findAll(SchoolClass.class);
	}
	
	@Override
	@Transactional
	public String getSchoolClassName(String branchName,String level) throws Exception {
		// TODO Auto-generated method stub
		int number = schoolClassDao.findNumber(level, branchName);
		return level+branchName+(number+1);
	}
	
	

}
