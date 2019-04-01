package com.HRMS.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
@Table(name="hrms_employee_trainings")
public class EmployeeVO_Training implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	
	private String skills;
	
	private String training;
	
	private String projectReqt;
	
	private Double bond;
	
	@OneToOne
	@JoinColumn(name="emp_Id")
	private EmployeeVO employeeVO;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getTraining() {
		return training;
	}

	public void setTraining(String training) {
		this.training = training;
	}

	public String getProjectReqt() {
		return projectReqt;
	}

	public void setProjectReqt(String projectReqt) {
		this.projectReqt = projectReqt;
	}

	public Double getBond() {
		return bond;
	}

	public void setBond(Double bond) {
		this.bond = bond;
	}

	public EmployeeVO getEmployeeVO() {
		return employeeVO;
	}

	public void setEmployeeVO(EmployeeVO employeeVO) {
		this.employeeVO = employeeVO;
	}

	@Override
	public String toString() {
		return "EmployeeVO_Training [Id=" + Id + ", skills=" + skills + ", training=" + training + ", projectReqt="
				+ projectReqt + ", bond=" + bond + ", employeeVO=" + employeeVO + "]";
	}
	

}
