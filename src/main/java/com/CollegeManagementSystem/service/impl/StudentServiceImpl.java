package com.CollegeManagementSystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CollegeManagementSystem.dao.StudentDAO;
import com.CollegeManagementSystem.model.Student;
import com.CollegeManagementSystem.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO;
	
	@Transactional
	public String zabouromWarning() {
		return studentDAO.toString();
	}
/*
	@Override
	@Transactional
	public List<Student> getStudents() {
		return studentDAO.getStudents();
	}

	@Override
	@Transactional
	public Student getStudentById(int id) {
		return studentDAO.getStudentById(id);
	}

	@Override
	@Transactional
	public void saveStudent(Student student) {
		studentDAO.saveStudent(student);

	}

	@Override
	@Transactional
	public void deleteStudent(int id) {
		studentDAO.deleteStudent(id);

	}*/

	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
