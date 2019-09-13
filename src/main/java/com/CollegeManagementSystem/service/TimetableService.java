package com.CollegeManagementSystem.service;

import java.util.List;

import com.CollegeManagementSystem.model.SchoolClass;
import com.CollegeManagementSystem.model.Timetable;

public interface TimetableService {

	void save(Timetable timetable) throws Exception;

	void delete(int id) throws Exception;

	Timetable find(int id) throws Exception;

	List<Timetable> findAll() throws Exception;

}
