package com.HRMS.Service;

import java.util.List;

import com.HRMS.Model.DepartmentVO;
import com.HRMS.Model.Projects;

public interface SetupService {
	public void addProjects(Projects p);
	public void addDepartment(DepartmentVO e);
	public List<DepartmentVO> listDepartments();

}
