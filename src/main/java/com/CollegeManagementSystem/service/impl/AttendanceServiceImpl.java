package com.CollegeManagementSystem.service.impl;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CollegeManagementSystem.dao.AttendanceDAO;
import com.CollegeManagementSystem.model.Absence;
import com.CollegeManagementSystem.model.Course;
import com.CollegeManagementSystem.model.Student;
import com.CollegeManagementSystem.service.AbsenceService;

@SuppressWarnings("unchecked")

@Service
public class AttendanceServiceImpl implements AbsenceService {

	@Autowired
	private AttendanceDAO absenceDAO;

	@Override
	@Transactional
	public void save(Absence absence) {
		absenceDAO.save(absence);
	}

	@Override
	@Transactional
	public void update(Absence absence) {
		absenceDAO.update(absence);
	}

	@Override
	@Transactional
	public void delete(int id) {
		Absence absence = this.findById(id);
		absenceDAO.delete(absence);
	}

	@Override
	@Transactional
	public List<Absence> findByStudentId(int studentId) {
		Criterion criterion = Restrictions.eq("student.id", studentId);
		List<Absence> absences = absenceDAO.findByCriteria(Student.class, criterion);
		return absences;
	}

	@Override
	@Transactional
	public List<Absence> findByCourseId(int courseId) {
		Criterion criterion = Restrictions.eq("course.id", courseId);
		List<Absence> absences = absenceDAO.findByCriteria(Course.class, criterion);
		return absences;
	}

	@Override
	@Transactional
	public Absence findById(int id) {
		return (Absence) absenceDAO.find(Absence.class, id);
	}

}
