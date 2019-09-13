package com.CollegeManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.CollegeManagementSystem.model.Branch;
import com.CollegeManagementSystem.model.Grade;
import com.CollegeManagementSystem.service.BranchService;
import com.CollegeManagementSystem.service.GradeService;

@Controller
@RequestMapping("/grade")
public class GradeController {

	@Autowired
	private GradeService gradeService;
	
	@Autowired
	private BranchService branchService;

	@RequestMapping(value="/listGrade", method=RequestMethod.GET)
	public String getGrade(Model model) throws Exception
	{
		List<Grade> listGrade = gradeService.findAll();
		System.out.println(listGrade.toString());
		model.addAttribute("gradeList",listGrade);
		return "/grade/listGrades";
	}
	
	
	@RequestMapping(value="/addGradeForm",method=RequestMethod.GET)
	public String showGradeAddForm(Model model) throws Exception
	{ 	
		Grade grade = new Grade();
		grade.setBranch(new Branch());
/*		GradeForm gradeForm = new GradeForm();
		model.addAttribute("gradeForm", gradeForm);
*/
		model.addAttribute("grade", grade);
		List<Branch> listBranch = branchService.findAll();
		model.addAttribute("branchList",listBranch);
    	return "/grade/gradeForm";
	}
	
	@RequestMapping(value="/saveGrade",method=RequestMethod.POST)
	public String saveGrade(@ModelAttribute("grade") Grade grade) throws Exception
	{
		System.out.println("branch"+grade.getBranch().getId());
		gradeService.save(grade);
		return "redirect:/grade/listGrade";
	}
	
	@RequestMapping(value="/updateGradeForm",method=RequestMethod.GET)
	public String showGradeUpdateForm(@ModelAttribute("gradeId")int id, Model model) throws Exception
	{
		Grade grade = gradeService.find(id);
		model.addAttribute("grade",grade);
		List<Branch> listBranch = branchService.findAll();
		model.addAttribute("branchList",listBranch);
		
		return "/grade/gradeForm";
	}
	
	@RequestMapping(value="/deleteGrade", method=RequestMethod.GET)
	public String deleteGrade(@ModelAttribute("gradeId") int id) throws Exception
	{
	
		gradeService.delete(id);
		return "redirect:/grade/listGrade";
	}
	
}
