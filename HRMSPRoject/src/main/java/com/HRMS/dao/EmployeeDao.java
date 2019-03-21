package com.HRMS.dao;

import java.util.List;

import com.HRMS.Model.DepartmentVO;
import com.HRMS.Model.EmployeeVO;
import com.HRMS.Model.EmployeeVO_Login;
import com.HRMS.Model.Employee_Leaves;
import com.HRMS.Model.Leaves;

public interface EmployeeDao {
	public void addDepartment(DepartmentVO e);

	public EmployeeVO getEmployeeById(int id);
	public List<DepartmentVO> listDepartments();
	public void updateEmployeePassword(EmployeeVO_Login employeeLogin);
	public void addLeaves(Leaves l);
	public void sendLeaveRequest(Employee_Leaves employeeLeave);
	public List<Leaves> getAllLeaves();
	public void updateEmployeeProfilePic(EmployeeVO_Login employeeLogin);
}
