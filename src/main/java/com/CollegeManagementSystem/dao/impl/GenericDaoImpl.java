package com.CollegeManagementSystem.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;

import com.CollegeManagementSystem.dao.GenericDAO;


public class GenericDaoImpl implements GenericDAO {
	
	@Autowired
	protected SessionFactory sessionFactory;

	@Override
	public void save(Object obj) {
		sessionFactory.getCurrentSession().saveOrUpdate(obj);

	}

	@Override
	public void delete(Object obj) {
		sessionFactory.getCurrentSession().delete(obj);
	}

	@Override
	public Object find(Class cls,int id) {
		Object classe = (Object) sessionFactory.getCurrentSession().get(cls, id);
		return classe;
	}
	
	@Override
	public List findAll(Class cls) {
		List list = sessionFactory.getCurrentSession().createCriteria(cls).list();
		return list;
	}

	@Override
	public List findByCriteria(Class cls, Criterion crit) {
		List list = sessionFactory.getCurrentSession().createCriteria(cls).add(crit).list();
		return list;
	}
	
	@Override
	public Object findOneByCriteria(Class cls, Criterion criterion) {
		Session currentSession = sessionFactory.getCurrentSession();
		Criteria criteria = currentSession.createCriteria(cls);
		criteria.add(criterion);
		criteria.setMaxResults(1);
		Object object = criteria.uniqueResult();
		return object;
	}

	@Override
	public void update(Object obj) {
		// TODO Auto-generated method stub
		
	}
}
