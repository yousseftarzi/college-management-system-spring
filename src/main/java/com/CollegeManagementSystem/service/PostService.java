package com.CollegeManagementSystem.service;

import java.util.List;

import com.CollegeManagementSystem.model.Post;

public interface PostService {

	void save(Post post);

	void update(Post post);

	void delete(int id);

	List<Post> findAll();

	Post findById(int id);

	List<Post> findByAuthorId(int authorId);
}
