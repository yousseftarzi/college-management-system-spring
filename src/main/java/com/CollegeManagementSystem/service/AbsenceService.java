package com.CollegeManagementSystem.service;

import java.util.List;

import com.CollegeManagementSystem.model.Absence;

public interface AbsenceService {

	void save(Absence absence);

	void update(Absence absence);

	void delete(int id);

	List<Absence> findByStudentId(int studentId);

	List<Absence> findByCourseId(int courseId);

	Absence findById(int id);

}
