package com.HRMS.dao;

import java.util.List;

import com.HRMS.Model.DepartmentVO;
import com.HRMS.Model.Projects;

public interface SetupDao {
	public void addProjects(Projects p);
	public void addDepartment(DepartmentVO e);
	public List<DepartmentVO> listDepartments();

}
