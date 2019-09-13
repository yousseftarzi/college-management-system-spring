package com.CollegeManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.CollegeManagementSystem.model.Comment;
import com.CollegeManagementSystem.model.Post;
import com.CollegeManagementSystem.service.PostService;

@Controller
@RequestMapping("/post")
public class PostController {

	@Autowired
	private PostService postService;
	//@Autowired
	//private userService userService;

	@RequestMapping(path = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<Post> posts = postService.findAll();
		model.addAttribute("posts", posts);
		return "/post/post_list";
	}

	@RequestMapping(path = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") int id, Model model) {
		Post post = postService.findById(id);
		post.getComments();
		model.addAttribute("post", post);

		Comment comment = new Comment();
		comment.setPost(post);
		model.addAttribute("comment", comment);
		return "/post/show_post";
	}

	// List of the posts created by the connected user
	// chouf belk 5ir t3adi user service w tjib list te3 posts
	@RequestMapping(path = "/myPosts", method = RequestMethod.GET)
	public String listMyPosts(Model model) {
		int authorId = 1; // GET BY SESSION
		List<Post> myPosts = postService.findByAuthorId(authorId);
		model.addAttribute("myPosts", myPosts);
		return "/post/my_posts_list";
	}

	@RequestMapping(path = "/addForm", method = RequestMethod.GET)
	public String add(Model model) {
		Post post = new Post();
		model.addAttribute("post", post);
		return "/post/post_form";
	}

	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("post") Post post) {
		postService.save(post);
		return "redirect:/post/myPosts";
	}

	@RequestMapping(path = "/editForm", method = RequestMethod.GET)
	public String edit(@RequestParam("postId") int id, Model model) {
		Post post = postService.findById(id);
		model.addAttribute("post", post);
		return "/post/post_form";
	}

	@RequestMapping(path = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("post") Post post) {
		postService.save(post);
		return "redirect:/post/myPosts";
	}

	// normalement twali post mch get // chouf lo5rin wa9tech twali put
	@RequestMapping(path = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam("postId") int id) {
		postService.delete(id);
		return "redirect:/post/myPosts";
	}

}
