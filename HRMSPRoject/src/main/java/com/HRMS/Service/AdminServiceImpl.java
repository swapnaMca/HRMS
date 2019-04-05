package com.HRMS.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HRMS.Model.DepartmentVO;
import com.HRMS.Model.EmployeeVO;
import com.HRMS.Model.EmployeeVOImage;
import com.HRMS.Model.Employee_Leaves;
import com.HRMS.Model.Employee_Projects;
import com.HRMS.Model.Leaves;
import com.HRMS.Model.Projects;
import com.HRMS.dao.AdminDao;
import com.HRMS.dao.EmployeeDao;
import com.mysql.jdbc.Blob;

@Transactional
@Service("adminService")
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminDao adminDao;
	
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public void addEmployee(EmployeeVO e,String actionName) {
		adminDao.addEmployee(e,actionName);
		
	}
	public void updateEmployee(EmployeeVO e) {
		System.out.println("EmployeeServiceImpl********* updateEmployee"+e.getId()+"...."+e.getEmployeeLogin().getId());
		adminDao.updateEmployee(e);
		
	}

	
	
	public List<EmployeeVO> listPersons() {
		// TODO Auto-generated method stub
		return adminDao.listPersons();
	}

	
	
	public EmployeeVO getEmployeeById(int id) {
		return adminDao.getEmployeeById(id);
		
	}

	
	
	public void removeEmployee(int id) {
		adminDao.removeEmployee(id);
		
	}

	
	
	public List<DepartmentVO> listDepartments() {
		// TODO Auto-generated method stub
		System.out.println("*************listDepartments");
		return adminDao.listDepartments();
	}

	
	public void addDepartment(DepartmentVO e) {
		System.out.println("EmployeeServiceImpl********* addEmployee"+e.getDepartmentId());
		adminDao.addDepartment(e);
		
	}
	@Override
	public void addProjects(Employee_Projects employeeProjects) {
		adminDao.addProjects(employeeProjects);		
	}

	@Override
	public List<Projects> projectsList() {
		// TODO Auto-generated method stub
		return adminDao.projectsList();
	}

	
	public List<Employee_Leaves> leaveHistory(int empId) {
		// TODO Auto-generated method stub
		return adminDao.leaveHistory(empId);
	}

	@Override
	public void addEmployeeImage(EmployeeVOImage e) {
		adminDao.addEmployeeImage(e);
		
	}

	@Override
	public Blob getEmployeePhotoById(int id) {
		// TODO Auto-generated method stub
		return adminDao.getEmployeePhotoById(id);
	}

	@Override
	public void updateLeavesStatus(Employee_Leaves l,int employeeId) {
		adminDao.updateLeavesStatus(l,employeeId);
		
	}

	@Override
	public List<Employee_Leaves> leaveHistoryBydate(Date fromDate, Date toDate, String Status) {
			// TODO Auto-generated method stub
			return adminDao.leaveHistoryBydate(fromDate,toDate,Status);
		
	}

	
}
