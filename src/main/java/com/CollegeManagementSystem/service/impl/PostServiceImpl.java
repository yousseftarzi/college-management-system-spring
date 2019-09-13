package com.CollegeManagementSystem.service.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CollegeManagementSystem.dao.PostDAO;
import com.CollegeManagementSystem.model.Post;
import com.CollegeManagementSystem.model.User;
import com.CollegeManagementSystem.service.PostService;

@SuppressWarnings("unchecked") // Check if there's a better solution for suppress warning
@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostDAO postDAO;

	@Override
	@Transactional
	public void save(Post post) {
		User currentUser = new User();
		currentUser.setId(1);
		// User currentUser = session.load(Department.class,deptid); // tji fel daoimpl
		post.setAuthor(currentUser);
		postDAO.save(post);
	}

	@Override
	@Transactional
	public void update(Post post) {
		postDAO.update(post);
	}

	@Override
	@Transactional
	public void delete(int id) {
		Post post = this.findById(id);
		postDAO.delete(post);
	}

	@Override
	@Transactional
	public List<Post> findAll() {
		return postDAO.findAll(Post.class);
	}

	@Override
	@Transactional
	public Post findById(int id) {
		Post post = (Post) postDAO.find(Post.class, id);
		Hibernate.initialize(post.getComments());
		return post;
	}

	@Override
	@Transactional
	public List<Post> findByAuthorId(int authorId) {
		Criterion criterion = Restrictions.eq("author.id", authorId);
		List<Post> posts = postDAO.findByCriteria(Post.class, criterion);
		return posts;
	}

}
