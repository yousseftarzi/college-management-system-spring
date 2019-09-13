package com.CollegeManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.CollegeManagementSystem.form.ManageCourseForm;
import com.CollegeManagementSystem.form.ManageSchoolClassForm;
import com.CollegeManagementSystem.model.Course;
import com.CollegeManagementSystem.model.Professor;
import com.CollegeManagementSystem.model.SchoolClass;
import com.CollegeManagementSystem.service.CourseService;
import com.CollegeManagementSystem.service.ProfessorService;
import com.CollegeManagementSystem.service.SchoolClassService;

@Controller
@RequestMapping("/professor")
public class ProfessorController {

	@Autowired
	private ProfessorService professorService;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private SchoolClassService schoolClassService;
	
	@RequestMapping(value="/listProfessor", method=RequestMethod.GET)
	public String getProfessor(Model model) throws Exception
	{
		List<Professor> listProfessor= professorService.findAll();
		model.addAttribute("professorList",listProfessor);
		return "/template";
	}
	
	
	@RequestMapping(value="/addProfessorForm",method=RequestMethod.GET)
	public String showBranchAddForm(Model model)
	{ 	
		model.addAttribute("professor", new Professor());
    	return "/professor/professorForm";
	}
	
	@RequestMapping(value="/saveProfessor",method=RequestMethod.POST)
	public String saveProfessor(@ModelAttribute("professor") Professor professor) throws Exception
	{
		professorService.save(professor);
		return "redirect:/professor/listProfessor";
	}
	
	@RequestMapping(value="/manageCourseForm",method=RequestMethod.GET)
	public String manageCourseForm(@ModelAttribute("professorId") int id,Model model) throws Exception
	{
		Professor professor = professorService.find(id);
		List<Course> listCourse = courseService.findAll();
		Course course = new Course();
		ManageCourseForm manageCourseForm = new ManageCourseForm();
		manageCourseForm.setProfessor(professor);
		manageCourseForm.setCourse(course);
		model.addAttribute("manageCourseForm",manageCourseForm);
		model.addAttribute("courseList",listCourse);
		return "/course/manageCourseForm";
	}
	
	@RequestMapping(value="/manageSchoolClassForm",method=RequestMethod.GET)
	public String manageSchoolClassForm(@ModelAttribute("professorId") int id,Model model) throws Exception
	{
		Professor professor = professorService.find(id);
		List<SchoolClass> listSchoolClass = schoolClassService.findAll();
		SchoolClass schoolClass = new SchoolClass();
		ManageSchoolClassForm manageSchoolClassForm = new ManageSchoolClassForm();
		manageSchoolClassForm .setProfessor(professor);
		manageSchoolClassForm .setSchoolClass(schoolClass);
		model.addAttribute("manageSchoolClassForm",manageSchoolClassForm );
		model.addAttribute("schoolClassList",listSchoolClass);
		return "/schoolClass/manageClassForm";
	}
	
	@RequestMapping(value="/assignCourse",method=RequestMethod.POST)
	public String assignCourse(@ModelAttribute("manageCourseForm") ManageCourseForm manageCourseForm,Model model) throws Exception
	{
		professorService.assignCourse(manageCourseForm.getProfessor().getId(), manageCourseForm.getCourse().getId());
		//model.addAttribute("assignCourseForm",new AssignCourseForm());
		return this.manageCourseForm(manageCourseForm.getProfessor().getId(), model);
	}
	
	@RequestMapping(value="/unassignCourse",method=RequestMethod.GET)
	public String unassignCourse(@RequestParam("professorId") int idProfessor,@RequestParam("courseId") int idCourse,Model model) throws Exception
	{
		professorService.unassignCourse(idProfessor, idCourse);
		model.addAttribute("assignCourseForm",new ManageCourseForm());
		return this.manageCourseForm(idProfessor, model);
	}
	
	@RequestMapping(value="/assignSchoolClass",method=RequestMethod.POST)
	public String assignSchoolClass(@ModelAttribute("manageSchoolClassForm") ManageSchoolClassForm manageSchoolClassForm,Model model) throws Exception
	{
		professorService.assignSchoolClass(manageSchoolClassForm.getProfessor().getId(), manageSchoolClassForm.getSchoolClass().getId());
		return this.manageSchoolClassForm(manageSchoolClassForm.getProfessor().getId(), model);
	}
	
	@RequestMapping(value="/unassignSchoolClass",method=RequestMethod.GET)
	public String unassignSchoolClass(@RequestParam("professorId") int idProfessor,@RequestParam("schoolClassId") int idSchoolClass,Model model) throws Exception
	{
		professorService.unassignSchoolClass(idProfessor, idSchoolClass);
		model.addAttribute("manageSchoolClassForm",new ManageSchoolClassForm());
		//model.addAttribute("assignCourseForm",new AssignCourseForm());
		return this.manageSchoolClassForm(idProfessor, model);
	}
	
	@RequestMapping(value="/updateProfessorForm",method=RequestMethod.GET)
	public String UpdateProfessorForm(@ModelAttribute("professorId")int id, Model model) throws Exception
	{
		Professor professor = professorService.find(id);
		model.addAttribute(professor);
		
		return "/professor/professorForm";
	}
	
	@RequestMapping(value="/deleteProfessor", method=RequestMethod.GET)
	public String deleteProfessor(@ModelAttribute("professorId") int id) throws Exception
	{
	
		professorService.delete(id);
		return "redirect:/professor/listProfessor";
	}
}
