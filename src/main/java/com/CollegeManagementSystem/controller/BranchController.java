package com.CollegeManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.CollegeManagementSystem.model.Branch;
import com.CollegeManagementSystem.service.BranchService;

@Controller
@RequestMapping("/branch")
public class BranchController {

	@Autowired
	private BranchService branchService;
	
	@RequestMapping(value="/listBranch", method=RequestMethod.GET)
	public String getBranch(Model model) throws Exception
	{
		List<Branch> listBranch = branchService.findAll();
		model.addAttribute("branchList",listBranch);
		return "/branch/listBranches";
	}
	
	
	@RequestMapping(value="/addBranchForm",method=RequestMethod.GET)
	public String showBranchAddForm(Model model)
	{ 	
		model.addAttribute("branch", new Branch());
    	return "/branch/branchForm";
	}
	
	@RequestMapping(value="/saveBranch",method=RequestMethod.POST)
	public String saveBranch(@ModelAttribute("branch") Branch branch) throws Exception
	{
		branchService.save(branch);
		return "redirect:/branch/listBranch";
	}
	
	@RequestMapping(value="/updateBranchForm",method=RequestMethod.GET)
	public String showBranchUpdateForm(@ModelAttribute("branchId")int id, Model model) throws Exception
	{
		Branch branch = branchService.find(id);
		model.addAttribute(branch);
		
		return "/branch/branchForm";
	}
	
	@RequestMapping(value="/deleteBranch", method=RequestMethod.GET)
	public String deleteBranch(@ModelAttribute("branchId") int id) throws Exception
	{
	
		branchService.delete(id);
		return "redirect:/branch/listBranch";
	}
	
	
	
}
