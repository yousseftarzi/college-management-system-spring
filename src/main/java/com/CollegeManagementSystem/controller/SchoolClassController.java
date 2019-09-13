package com.CollegeManagementSystem.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.CollegeManagementSystem.form.AssignTimetableForm;
import com.CollegeManagementSystem.model.Branch;
import com.CollegeManagementSystem.model.Grade;
import com.CollegeManagementSystem.model.SchoolClass;
import com.CollegeManagementSystem.model.Timetable;
import com.CollegeManagementSystem.service.BranchService;
import com.CollegeManagementSystem.service.GradeService;
import com.CollegeManagementSystem.service.SchoolClassService;
import com.CollegeManagementSystem.service.TimetableService;

@Controller
@RequestMapping("/schoolClass")
public class SchoolClassController {
	private static final String UPLOAD_DIRECTORY ="/images";  
	
	@Autowired
	private SchoolClassService schoolClassService;
	
	@Autowired
	private BranchService branchService;
	
	@Autowired
	private GradeService gradeService;
	
	@Autowired
	private TimetableService timetableService;
	
	@RequestMapping(value="/listSchoolClass", method=RequestMethod.GET)
	public String getSchoolClass(Model model) throws Exception
	{
		List<SchoolClass> listSchoolClass = schoolClassService.findAll();
		model.addAttribute("schoolClassList",listSchoolClass);
		return "/schoolClass/listSchoolClasses";
	}
	
	
	@RequestMapping(value="/addSchoolClassForm",method=RequestMethod.GET)
	public String AddSchoolClassForm(Model model) throws Exception
	{ 	
    	
		Grade grade = new Grade();
		grade.setBranch(new Branch());
		List<Branch> listBranch = branchService.findAll();
		SchoolClass schoolClass = new SchoolClass();
		schoolClass.setGrade(grade);
		model.addAttribute("schoolClass", schoolClass);
		model.addAttribute("branchList",listBranch);
    	return "/schoolClass/schoolClassForm";
	}
	
	@RequestMapping(value="/saveSchoolClass",method=RequestMethod.POST)
	public String saveSchoolClass(@ModelAttribute("schoolClass") SchoolClass schoolClass) throws Exception
	{
		Branch branch = branchService.findByName(schoolClass.getGrade().getBranch().getName());
		Grade grade = gradeService.findByLevelandBranch(schoolClass.getGrade().getLevel(), branch);
		schoolClass.setGrade(grade);
		if ( schoolClass.getName() == null || schoolClass.getName().isEmpty())
		schoolClass.setName(schoolClassService.getSchoolClassName(schoolClass.getGrade().getBranch().getName(), schoolClass.getGrade().getLevel()));

		if (schoolClass.getStudents() != null && schoolClass.getCapacity()>schoolClass.getStudents().size())
		{
			System.out.println("Error");
			return "null";
		}
		schoolClassService.save(schoolClass);
		return "redirect:/schoolClass/listSchoolClass";
	}
	
	@RequestMapping(value="/assignTimetableForm",method=RequestMethod.GET)
	public String assignTimetableForm(@ModelAttribute("schoolClassId")int id, Model model) throws Exception
	{
		SchoolClass schoolClass= schoolClassService.find(id);
		Timetable timetable = new Timetable();
		timetable.setUploadedAt(new Date());
		AssignTimetableForm assignTimetableForm = new AssignTimetableForm();
		assignTimetableForm.setSchoolClass(schoolClass);
		assignTimetableForm.setTimetable(timetable);
		model.addAttribute("assignTimetableForm",assignTimetableForm);
		return "/schoolClass/timetableForm";
	}
	
	@RequestMapping(value="/assignTimetable",method=RequestMethod.GET)
	public String assignTimetable(@ModelAttribute("file")MultipartFile astf, Model model, HttpSession session) throws Exception
	{
		System.out.println("bbbbbbbbbbbbbbbb");
		System.out.println("aaaaaaaaaaaaaaaaaaa"+astf);
		ServletContext context = session.getServletContext();  
	    String path = context.getRealPath(UPLOAD_DIRECTORY);  
	    String filename = astf.getOriginalFilename();  
	  
	    System.out.println(path+" "+filename);        
	  
	    byte[] bytes = astf.getBytes();  
	    BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(  
	         new File(path + File.separator + filename)));  
	    stream.write(bytes);  
	    stream.flush();  
	    stream.close();  
	    
	 /*   astf.getTimetable().setFile(path+" "+filename);
	    astf.getSchoolClass().setTimetable(astf.getTimetable());
	    schoolClassService.save(astf.getSchoolClass());
	    timetableService.save(astf.getTimetable());*/
	    
	    return "/schoolClass/listSchoolClasses";
	}
	
	@RequestMapping(value="/updateSchoolClassForm",method=RequestMethod.GET)
	public String UpdateSchoolClassForm(@ModelAttribute("schoolClassId")int id, Model model) throws Exception
	{
		SchoolClass schoolClass= schoolClassService.find(id);
		model.addAttribute(schoolClass);
		
		return "/schoolClass/schoolClassForm";
	}
	
	@RequestMapping(value="/deleteSchoolClass", method=RequestMethod.GET)
	public String deleteSchoolClass(@ModelAttribute("schoolClassId") int id) throws Exception
	{
	
		schoolClassService.delete(id);
		return "redirect:/schoolClass/listSchoolClass";
	}
}
