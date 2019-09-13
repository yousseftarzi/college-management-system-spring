package com.CollegeManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.CollegeManagementSystem.model.Student;
import com.CollegeManagementSystem.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	@RequestMapping(path="/list", method=RequestMethod.GET)
	public String listStudents(Model model) {
		
		List<Student> students = studentService.findAll();
		model.addAttribute("students", students);
		return "list-students";
	}

	@RequestMapping(path="/showFormForAdd", method=RequestMethod.GET)
	public String showFormForAdd(Model model) {
		
		Student student = new Student();
		model.addAttribute("student", student);
		return "student-form";
	}

	@RequestMapping(path="/saveStudent", method=RequestMethod.POST)
	public String saveStudent(@ModelAttribute("student") Student student) {
		
		studentService.save(student);
		return "redirect:/student/list";
	}

	@RequestMapping(path="/showFormForUpdate", method=RequestMethod.GET)
	public String showFormForUpdate(@RequestParam("studentId") int id, Model model) {
		
		Student student = studentService.findById(id);
		model.addAttribute("student", student);
		return "student-form";
	}

	//normalement twali post mch get
	@RequestMapping(path = "/delete", method=RequestMethod.GET)
	public String deleteStudent(@RequestParam("studentId") int id) {
		//studentService.delete();
		return "redirect:/student/list";
	}

}
