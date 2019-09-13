package com.CollegeManagementSystem.form;

import org.springframework.web.multipart.MultipartFile;

import com.CollegeManagementSystem.model.SchoolClass;
import com.CollegeManagementSystem.model.Timetable;

public class AssignTimetableForm {

	private SchoolClass schoolClass;
	private Timetable timetable;
	private MultipartFile file;
	
	public SchoolClass getSchoolClass() {
		return schoolClass;
	}
	public void setSchoolClass(SchoolClass schoolClass) {
		this.schoolClass = schoolClass;
	}
	public Timetable getTimetable() {
		return timetable;
	}
	public void setTimetable(Timetable timetable) {
		this.timetable = timetable;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}

	
		
	
}
