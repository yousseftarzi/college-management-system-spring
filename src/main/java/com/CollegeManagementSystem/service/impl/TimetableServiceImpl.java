package com.CollegeManagementSystem.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CollegeManagementSystem.dao.TimetableDao;
import com.CollegeManagementSystem.model.Timetable;
import com.CollegeManagementSystem.service.TimetableService;

@Service
public class TimetableServiceImpl implements TimetableService{

	@Autowired
	private TimetableDao timetableDao;
	
	@Override
	@Transactional
	public void save(Timetable timetable) throws Exception {
		// TODO Auto-generated method stub
		timetableDao.save(timetable);
	}

	@Override
	@Transactional
	public void delete(int id) throws Exception {
		// TODO Auto-generated method stub
		Timetable timetable = (Timetable) timetableDao.find(Timetable.class, id);
		timetableDao.delete(timetable);
	}

	@Override
	@Transactional
	public Timetable find(int id) throws Exception {
		// TODO Auto-generated method stub
		Timetable timetable= (Timetable) timetableDao.find(Timetable.class, id);
		return timetable;
	}

	@Override
	@Transactional
	public List<Timetable> findAll() throws Exception {
		// TODO Auto-generated method stub
		return timetableDao.findAll(Timetable.class);
	}
	
}
