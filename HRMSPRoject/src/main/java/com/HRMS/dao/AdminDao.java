package com.HRMS.dao;

import java.util.List;

import com.HRMS.Model.DepartmentVO;
import com.HRMS.Model.EmployeeVO;
import com.HRMS.Model.EmployeeVOImage;
import com.HRMS.Model.Employee_Leaves;
import com.HRMS.Model.Employee_Projects;
import com.HRMS.Model.Projects;
import com.mysql.jdbc.Blob;

public interface AdminDao {
	
	public void addEmployee(EmployeeVO e);
	public void addEmployeeImage(EmployeeVOImage e);
	public void addDepartment(DepartmentVO e);
	public void updateEmployee(EmployeeVO e);
	public List<EmployeeVO> listPersons();
	public EmployeeVO getEmployeeById(int id);
	public Blob getEmployeePhotoById(int id);
	public void removeEmployee(int id);
	public List<DepartmentVO> listDepartments();
	
	public List<Employee_Leaves> leaveHistory(int empId);

	/*Project Module */
	public void addProjects(Employee_Projects employeeProjects);
	public List<Projects> projectsList();
}
