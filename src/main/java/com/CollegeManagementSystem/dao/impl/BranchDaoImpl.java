package com.CollegeManagementSystem.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.CollegeManagementSystem.dao.BranchDao;
import com.CollegeManagementSystem.model.Branch;

@Repository
public class BranchDaoImpl extends GenericDaoImpl implements BranchDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Branch findByName(String name)
	{
		Session currentSession = sessionFactory.getCurrentSession();
		Criterion criterion = Restrictions.eq("name", name);
		List<Branch> branch = currentSession.createCriteria(Branch.class).add(criterion).list();
		return branch.get(0);
	}
}
