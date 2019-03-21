package com.HRMS.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DEPARTMENT")
public class DepartmentVO {
	@Id
	@Column(name = "DEPARTMENT_Id")
	private int DepartmentId;

	@Column(name = "DEPARTMENT_Name")
	private String DepartmentName;

	@Column(name = "DEPARTMENT_Loc")
	private String DepartmentLoc;

	public int getDepartmentId() {
		return DepartmentId;
	}

	public void setDepartmentId(int departmentId) {
		DepartmentId = departmentId;
	}

	public String getDepartmentName() {
		return DepartmentName;
	}

	public void setDepartmentName(String departmentName) {
		DepartmentName = departmentName;
	}

	public String getDepartmentLoc() {
		return DepartmentLoc;
	}

	public void setDepartmentLoc(String departmentLoc) {
		DepartmentLoc = departmentLoc;
	}
	@Override
	public String toString() {
		return "DepartmentVO [DepartmentId=" + DepartmentId + ", departmentName=" + DepartmentName
				+ ", departmentLoc=" + DepartmentLoc + "]";
	}

}
