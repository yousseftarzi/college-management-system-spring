package com.CollegeManagementSystem.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.CollegeManagementSystem.dao.BranchDao;
import com.CollegeManagementSystem.dao.GradeDao;
import com.CollegeManagementSystem.model.Branch;
import com.CollegeManagementSystem.model.Grade;
import com.CollegeManagementSystem.model.Professor;

@Repository
public class GradeDaoImpl extends GenericDaoImpl implements GradeDao{
	
	@Autowired
	private BranchDao branchDao;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Grade> findAll(Class cls){
		Criteria criteria = super.sessionFactory.getCurrentSession().createCriteria(Grade.class);
		criteria.addOrder(Order.asc("level"));
		return criteria.list();	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Grade findByLevelandBranch(String level,Branch branch){
		Session currentSession = sessionFactory.getCurrentSession();
		Criterion criterion = Restrictions.eq("level", level);
		Criterion criterion1 = Restrictions.eq("branch.id", branch.getId());
		Grade grade= (Grade) currentSession.createCriteria(Grade.class).add(criterion).add(criterion1).list().get(0);
		return grade;
	}
	
	/*@Override
	public int getClassNumber(String level,String branchName){
//		Branch branch = branchDao.findByName(branchName);
		List<Grade> listGrade = this.findByLevelandGrade(level, branchName);
		return listGrade.size()+1;	
	}*/
}
