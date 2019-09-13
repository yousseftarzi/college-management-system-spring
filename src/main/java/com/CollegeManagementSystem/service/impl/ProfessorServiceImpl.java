package com.CollegeManagementSystem.service.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CollegeManagementSystem.dao.CourseDao;
import com.CollegeManagementSystem.dao.ProfessorDao;
import com.CollegeManagementSystem.dao.SchoolClassDao;
import com.CollegeManagementSystem.model.Course;
import com.CollegeManagementSystem.model.Professor;
import com.CollegeManagementSystem.model.SchoolClass;
import com.CollegeManagementSystem.service.ProfessorService;

@Service
public class ProfessorServiceImpl implements ProfessorService {

	@Autowired
	private ProfessorDao professorDao;
	@Autowired
	private CourseDao courseDao;
	@Autowired
	private SchoolClassDao schoolClassDao;
	
	@Override
	@Transactional
	public int save(Professor professor) throws Exception {
		// TODO Auto-generated method stub
		professorDao.save(professor);
		return professor.getId();
	}

	@Override
	@Transactional
	public List<Professor> findAll() throws Exception {
		// TODO Auto-generated method stub
		return professorDao.findAll(Professor.class);
	}

	@Override
	@Transactional
	public Professor find(int id) throws Exception {
		// TODO Auto-generated method stubs
		Professor professor = (Professor) professorDao.find(Professor.class,id);
		Hibernate.initialize(professor.getCourses());
		Hibernate.initialize(professor.getSchoolClasses());
		return professor;
	}

	@Override
	@Transactional
	public int delete(int id) throws Exception {
		// TODO Auto-generated method stub
		Professor professor = new Professor();
		professor.setId(id);
		professorDao.delete(professor);
		return id;
	}

	@Override
	@Transactional
	public Professor findByEmail(String email) {
		// TODO Auto-generated method stub
		return professorDao.findByEmail(email);
	}

	@Override
	@Transactional
	public void assignCourse(int idProfessor, int idCourse) throws Exception {
		// TODO Auto-generated method stub
			Professor professor = (Professor) professorDao.find(Professor.class, idProfessor);
			Course course = (Course) courseDao.find(Course.class, idCourse);
			professorDao.assignCourse(professor, course);
	}

	@Override
	@Transactional
	public void unassignCourse(int idProfessor, int idCourse) throws Exception {
		// TODO Auto-generated method stub
		Professor professor = (Professor) professorDao.find(Professor.class, idProfessor);
		Course course = (Course) courseDao.find(Course.class, idCourse);
		professorDao.unassignCourse(professor, course);
	}

	@Override
	@Transactional
	public void assignSchoolClass(int idProfessor, int idSchoolClass) throws Exception {
		// TODO Auto-generated method stub
		Professor professor = (Professor) professorDao.find(Professor.class, idProfessor);
		SchoolClass schoolClass= (SchoolClass) schoolClassDao.find(SchoolClass.class, idSchoolClass);
		professorDao.assignSchoolClass(professor, schoolClass);
	}

	@Override
	@Transactional
	public void unassignSchoolClass(int idProfessor, int idSchoolClass) throws Exception {
		// TODO Auto-generated method stub
		Professor professor = (Professor) professorDao.find(Professor.class, idProfessor);
		SchoolClass schoolClass= (SchoolClass) schoolClassDao.find(SchoolClass.class, idSchoolClass);
		professorDao.unassignSchoolClass(professor, schoolClass);
	}

	
}
