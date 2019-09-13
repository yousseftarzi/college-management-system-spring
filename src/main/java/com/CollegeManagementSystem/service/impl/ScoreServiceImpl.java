package com.CollegeManagementSystem.service.impl;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CollegeManagementSystem.dao.ScoreDAO;
import com.CollegeManagementSystem.model.Score;
import com.CollegeManagementSystem.service.ScoreService;

@Service
public class ScoreServiceImpl implements ScoreService {

	@Autowired
	private ScoreDAO scoreDAO;

	@Override
	@Transactional
	public void save(Score score) {
		scoreDAO.save(score);

	}

	@Override
	@Transactional
	public void update(Score score) {
		scoreDAO.update(score);

	}

	@Override
	@Transactional
	public void delete(int id) {
		Score score = this.findById(id);
		scoreDAO.delete(score);
	}

	@Override
	@Transactional
	public Score findOneByAssignmentId(int assignmentId) {
		Criterion criterion = Restrictions.eq("assignment.id", assignmentId);
		Score score = (Score) scoreDAO.findOneByCriteria(Score.class, criterion);
		return score;
	}

	@Override
	@Transactional
	public Score findById(int id) {
		return (Score) scoreDAO.find(Score.class, id);
	}

}
