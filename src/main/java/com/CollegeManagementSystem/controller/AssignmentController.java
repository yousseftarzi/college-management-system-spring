package com.CollegeManagementSystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.CollegeManagementSystem.model.Assignment;
import com.CollegeManagementSystem.model.Category;
import com.CollegeManagementSystem.model.SchoolClass;
import com.CollegeManagementSystem.service.AssignmentService;

@Controller
@RequestMapping("/assignment")
public class AssignmentController {
	@Autowired
	private AssignmentService assignmentService;
	
	@RequestMapping(path = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		int courseId = 1; //Change this 
		List<Assignment> assignments = assignmentService.findByCourseId(courseId);
		model.addAttribute("assignments", assignments);
		return "/assignment/assignment_list";
	}
	
	@RequestMapping(path = "/addForm", method = RequestMethod.GET)
	public String add(Model model) {
		Assignment assignment = new Assignment();
		model.addAttribute("categories", Category.values());
		model.addAttribute("assignment", assignment);
		//See how to get the classes that are studying this course for this professor
		SchoolClass schoolClass = new SchoolClass();
		schoolClass.setId(1);
		SchoolClass schoolClass2 = new SchoolClass();
		schoolClass2.setId(2);
		SchoolClass schoolClass3 = new SchoolClass();
		schoolClass3.setId(3);
		List<SchoolClass> schoolClasses = new ArrayList<>();
		schoolClasses.add(schoolClass);
		schoolClasses.add(schoolClass2);
		schoolClasses.add(schoolClass3);
		model.addAttribute(schoolClasses);
		////////////////////////////////////////////
		return "/assignment/add_form";
	}
	
	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("assignment") Assignment assignment) {
		assignmentService.save(assignment);
		return "redirect:/assignment/list";
	}
	
	@RequestMapping(path = "/editForm", method = RequestMethod.GET)
	public String edit(@RequestParam("assignmentId") int id, Model model) {
		Assignment assignment = assignmentService.findById(id);
		model.addAttribute("assignment", assignment);
		return "/assignment/edit_form";
	}

	@RequestMapping(path = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("assignment") Assignment assignment) {
		assignmentService.save(assignment);
		return "redirect:/assignment/list";
	}

	// normalement twali post mch get // chouf lo5rin wa9tech twali put
	@RequestMapping(path = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam("assignmentId") int id) {
		assignmentService.delete(id);
		return "redirect:/assignment/list";
	}
	
	
	

}
