package com.CollegeManagementSystem.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CollegeManagementSystem.dao.CommentDAO;
import com.CollegeManagementSystem.model.Comment;
import com.CollegeManagementSystem.model.User;
import com.CollegeManagementSystem.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDAO commentDAO;

	@Override
	@Transactional
	public void save(Comment comment) {
		User currentUser = new User(); // Get by session //chouf el set te3 user w date be9i yet7at hné wela fe
										// controller, belk user controller w be9i hné
		currentUser.setId(1);
		comment.setAuthor(currentUser);
		Date now = new Date();
		comment.setCreatedAt(now);
		commentDAO.save(comment);
	}

	@Override
	@Transactional
	public void update(Comment comment) {
		commentDAO.update(comment);
	}

	@Override
	@Transactional
	public void delete(int id) {
		Comment comment = this.findById(id);
		commentDAO.delete(comment);
	}

	@Override
	@Transactional
	public Comment findById(int id) {
		Comment comment = (Comment) commentDAO.find(Comment.class, id);
		return comment;
	}

}
