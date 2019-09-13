package com.CollegeManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.CollegeManagementSystem.model.Comment;
import com.CollegeManagementSystem.service.CommentService;

@Controller
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	private CommentService commentService;

	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("comment") Comment comment, Model model) {
		commentService.save(comment);
		model.addAttribute("postId", comment.getPost().getId());
		return "redirect:/post/show/{postId}";
	}

	@RequestMapping(path = "/edit", method = RequestMethod.GET)
	public String showFormForUpdate(@RequestParam("commentId") int id, Model model) {
		Comment comment = commentService.findById(id);
		model.addAttribute("comment", comment);
		//model.addAttribute("postId", comment.getPost().getId());
		return "/comment/comment_form";
	}

	@RequestMapping(path = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("comment") Comment comment, Model model) {
		commentService.update(comment);
		//model.addAttribute("postId", comment.getPost().getId());
		return "redirect:/post/showPost/{comment.post.id}";
	}

	// normalement twali post mch get
	@RequestMapping(path = "/delete", method = RequestMethod.GET)
	public String deleteComment(@RequestParam("commentId") int id, Model model) {
		Comment comment = commentService.findById(id);
		commentService.delete(id);
		model.addAttribute("postId", comment.getPost().getId());
		return "redirect:/post/show/{postId}";
	}

}
