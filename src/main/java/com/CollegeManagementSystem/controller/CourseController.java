package com.CollegeManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.CollegeManagementSystem.model.Course;
import com.CollegeManagementSystem.model.Grade;
import com.CollegeManagementSystem.service.CourseService;
import com.CollegeManagementSystem.service.GradeService;


@Controller
@RequestMapping("/course")
public class CourseController {

	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private GradeService gradeService;
	
	@RequestMapping(value="/listCourse", method=RequestMethod.GET)
	public String getCourse(Model model) throws Exception
	{
		List<Course> listCourse= courseService.findAll();
		model.addAttribute("courseList",listCourse);
		return "/course/listCourses";
	}
	
	
	@RequestMapping(value="/addCourseForm",method=RequestMethod.GET)
	public String AddCourseForm(Model model) throws Exception
	{ 	
		List<Grade> listGrade = gradeService.findAll();
		Course course = new Course();
		Grade grade = new Grade();
		course.setGrade(grade);
		model.addAttribute("course", course);
		model.addAttribute("gradeList",listGrade);
    	return "/course/courseForm";
	}
	
	@RequestMapping(value="/saveCourse",method=RequestMethod.POST)
	public String saveCourse(@ModelAttribute("course") Course course) throws Exception
	{
		courseService.save(course);
		return "redirect:/course/listCourse";
	}
	
	@RequestMapping(value="/updateCourseForm",method=RequestMethod.GET)
	public String UpdateCourseForm(@ModelAttribute("courseId")int id, Model model) throws Exception
	{
		Course course = courseService.find(id);
		List<Grade> listGrade = gradeService.findAll();
		model.addAttribute(course);
		model.addAttribute("gradeList",listGrade);
		
		return "/course/courseForm";
	}
	
	@RequestMapping(value="/deleteCourse", method=RequestMethod.GET)
	public String deleteCourse(@ModelAttribute("courseId") int id) throws Exception
	{
	
		courseService.delete(id);
		return "redirect:/course/listCourse";
	}
}
