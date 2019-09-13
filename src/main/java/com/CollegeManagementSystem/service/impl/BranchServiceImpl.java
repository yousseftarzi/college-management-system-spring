package com.CollegeManagementSystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CollegeManagementSystem.dao.BranchDao;
import com.CollegeManagementSystem.model.Branch;
import com.CollegeManagementSystem.service.BranchService;

@Service
public class BranchServiceImpl implements BranchService {

	@Autowired
	private BranchDao branchDao;
	
	@Override
	@Transactional
	public int save(Branch branch) throws Exception {
		// TODO Auto-generated method stub
		branchDao.save(branch);
		return branch.getId();
	}

	@Override
	@Transactional
	public List<Branch> findAll() throws Exception {
		// TODO Auto-generated method stub
		return branchDao.findAll(Branch.class);
		
	}
	
	@Override
	@Transactional
	public Branch find(int id) throws Exception {
		// TODO Auto-generated method stub
		return (Branch) branchDao.find(Branch.class,id);
		
	}

	@Override
	@Transactional
	public int delete(int id) throws Exception {
//		 Branch branch = (Branch) branchDao.find(Branch.class, id);
		Branch branch = new Branch();
		branch.setId(id);
		branchDao.delete(branch);
		 return id;
	}
	
	@Override
	@Transactional
	public Branch findByName(String name) {
		return branchDao.findByName(name);
	}
	

	
}
