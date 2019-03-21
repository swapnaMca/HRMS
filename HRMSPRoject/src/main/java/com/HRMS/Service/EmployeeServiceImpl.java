package com.HRMS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HRMS.Model.DepartmentVO;
import com.HRMS.Model.EmployeeVO;
import com.HRMS.Model.EmployeeVO_Login;
import com.HRMS.Model.Employee_Leaves;
import com.HRMS.Model.Leaves;
import com.HRMS.dao.EmployeeDao;
import com.HRMS.dao.LoginDao;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeDao employeeDao;
	
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}


	@Transactional
	public EmployeeVO getEmployeeById(int id) {
		return employeeDao.getEmployeeById(id);
		
	}
	@Transactional
	public List<DepartmentVO> listDepartments() {
		// TODO Auto-generated method stub
		System.out.println("*************listDepartments");
		return employeeDao.listDepartments();
	}

	@Transactional
	public void addDepartment(DepartmentVO e) {
		System.out.println("EmployeeServiceImpl********* addEmployee"+e.getDepartmentId());
		employeeDao.addDepartment(e);
		
	}


	@Transactional
	public void updateEmployeePassword(EmployeeVO_Login employeeLogin) {
		employeeDao.updateEmployeePassword(employeeLogin);
	}
	
	@Transactional
	public void addLeaves(Leaves l) {
		employeeDao.addLeaves(l);		
	}

	@Transactional
	public void sendLeaveRequest(Employee_Leaves employeeLeave) {
		employeeDao.sendLeaveRequest(employeeLeave);		
	}


	@Transactional
	public List<Leaves> getAllLeaves() {
		// TODO Auto-generated method stub
		return employeeDao.getAllLeaves();
	}


	@Transactional
	public void updateEmployeeProfilePic(EmployeeVO_Login employeeLogin) {
		employeeDao.updateEmployeeProfilePic(employeeLogin);
		
	}

	


	

}
