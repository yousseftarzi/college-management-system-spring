package com.CollegeManagementSystem.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.CollegeManagementSystem.dao.SchoolClassDao;
import com.CollegeManagementSystem.model.Grade;
import com.CollegeManagementSystem.model.Professor;
import com.CollegeManagementSystem.model.SchoolClass;

@Repository
public class SchoolClassDaoImpl extends GenericDaoImpl implements SchoolClassDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Grade> findAll(Class cls){
		Criteria criteria = super.sessionFactory.getCurrentSession().createCriteria(SchoolClass.class);
		criteria.addOrder(Order.asc("name"));
		return criteria.list();	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public int findNumber(String level,String branchName)
	{
		Session currentSession = sessionFactory.getCurrentSession();
		Criterion criterion = Restrictions.like("name", level+branchName+"%", MatchMode.ANYWHERE);
		List<SchoolClass> schoolClassList = currentSession.createCriteria(SchoolClass.class).add(criterion).list();
		return schoolClassList.size();
	}
}
