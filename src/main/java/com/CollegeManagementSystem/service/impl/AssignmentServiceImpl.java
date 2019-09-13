package com.CollegeManagementSystem.service.impl;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CollegeManagementSystem.dao.AssignmentDAO;
import com.CollegeManagementSystem.model.Assignment;
import com.CollegeManagementSystem.service.AssignmentService;

@Service
public class AssignmentServiceImpl implements AssignmentService {

	@Autowired
	private AssignmentDAO assignmentDAO;

	@Override
	@Transactional
	public void save(Assignment assignment) {
		assignmentDAO.save(assignment);
	}

	@Override
	@Transactional
	public void update(Assignment assignment) {
		assignmentDAO.update(assignment);
	}

	@Override
	@Transactional
	public void delete(int id) {
		Assignment assignment = this.findById(id);
		assignmentDAO.delete(assignment);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Assignment> findByCourseId(int courseId) {
		Criterion criterion = Restrictions.eq("course.id", courseId);
		List<Assignment> assignments = assignmentDAO.findByCriteria(Assignment.class, criterion);
		return assignments;
	}

	@Override
	@Transactional
	public Assignment findById(int id) {
		return (Assignment) assignmentDAO.find(Assignment.class, id);
	}

}
