package com.HRMS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HRMS.Model.DepartmentVO;
import com.HRMS.Model.Projects;
import com.HRMS.dao.AdminDao;
import com.HRMS.dao.SetupDao;

@Transactional
@Service("setupService")
public class SetupServiceImpl implements SetupService{

	@Autowired
	SetupDao setupDao; 
	
	@Override
	public void addProjects(Projects p) {
	
		setupDao.addProjects(p);
	}

	public void addDepartment(DepartmentVO e) {
		setupDao.addDepartment(e);		
	}
	public List<DepartmentVO> listDepartments() {
		// TODO Auto-generated method stub
		return setupDao.listDepartments();
	}
}
