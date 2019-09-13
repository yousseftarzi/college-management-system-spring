package com.CollegeManagementSystem.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;

@SuppressWarnings("rawtypes") // Check if there's a better solution than @SuppressWarnings
public interface GenericDAO {

	void save(Object obj);

	void update(Object obj);

	void delete(Object obj);

	List findAll(Class cls);
	
	Object find(Class cls, int id);

	List findByCriteria(Class cls, Criterion crit);

	Object findOneByCriteria(Class cls, Criterion criterion);

}
