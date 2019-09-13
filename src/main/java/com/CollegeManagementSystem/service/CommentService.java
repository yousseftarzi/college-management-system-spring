package com.CollegeManagementSystem.service;

import com.CollegeManagementSystem.model.Comment;

public interface CommentService {

	void save(Comment comment);

	void update(Comment comment);

	void delete(int id);

	Comment findById(int id);

}
