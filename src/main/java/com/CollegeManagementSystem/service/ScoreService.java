package com.CollegeManagementSystem.service;

import com.CollegeManagementSystem.model.Score;

public interface ScoreService {
	void save(Score score);

	void update(Score score);

	void delete(int id);

	Score findOneByAssignmentId(int assignmentId); // chouf fel functions lo5rin t3adich ID bark w zid lawej akther
													// object vs id

	Score findById(int id);

}
