package com.CollegeManagementSystem.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.CollegeManagementSystem.dao.ProfessorDao;
import com.CollegeManagementSystem.model.Course;
import com.CollegeManagementSystem.model.Professor;
import com.CollegeManagementSystem.model.SchoolClass;

@Repository
public class ProfessorDaoImpl extends GenericDaoImpl implements ProfessorDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Professor findByEmail(String email) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Criterion criterion = Restrictions.eq("email", email);
		List<Professor> professorList = currentSession.createCriteria(Professor.class).add(criterion).list();
		return professorList.get(0);
	}
	
	@Override
	public void assignCourse(Professor professor, Course course) {
		// TODO Auto-generated method stub
		professor.getCourses().add(course);
		this.save(professor);
	}
	
	@Override
	public void unassignCourse(Professor professor, Course course) {
		// TODO Auto-generated method stub
		professor.getCourses().remove(course);
		this.save(professor);
	}
	
	@Override
	public void assignSchoolClass(Professor professor, SchoolClass schoolClass) {
		// TODO Auto-generated method stub
		professor.getSchoolClasses().add(schoolClass);
		this.save(professor);
	}
	
	@Override
	public void unassignSchoolClass(Professor professor,SchoolClass schoolClass) {
		// TODO Auto-generated method stub
		professor.getSchoolClasses().remove(schoolClass);
		this.save(professor);
	}
	
}
