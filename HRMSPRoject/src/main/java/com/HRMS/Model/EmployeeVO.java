package com.HRMS.Model;



import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Value;


@Entity
@Table(name="hrms_employee_details")
public class EmployeeVO implements Serializable 
{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	//@NotEmpty(message="${valid.uname}")
	
	@Column(name="firstname")
	private String firstName;
	
//	@NotEmpty(message="is Required")
	@Column(name="lastname")
	private String lastName;

	//@NotEmpty(message="is Required")
	@Column(name="phone")
	private String phone;
	
	//@NotEmpty(message="is Required")
	@Column(name="dateofbirth")
	private String dateOfBirth;
	
	//@NotEmpty(message="is Required")
	@Column(name="hire_date")
	private String hire_date;
	
	//@NotEmpty(message="is Required")
	@Column(name="job_id")
	private Integer job_id;
	
	//@NotEmpty(message="is Required")
	@Column(name="salary" , precision = 8, scale = 2)
	private BigDecimal  salary;
	
	
	
	
	//@NotEmpty(message="is Required")
	@Column(name="DEPT_Id")
	private String department_id;
	
	
	@OneToOne(mappedBy="employeeVO" ,cascade=CascadeType.ALL)
	private EmployeeVO_Login employeeLogin;
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}




	public EmployeeVO_Login getEmployeeLogin() {
		return employeeLogin;
	}


	public void setEmployeeLogin(EmployeeVO_Login employeeLogin) {
		this.employeeLogin = employeeLogin;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getHire_date() {
		return hire_date;
	}


	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}


	public Integer getJob_id() {
		return job_id;
	}


	public void setJob_id(Integer job_id) {
		this.job_id = job_id;
	}


	public BigDecimal getSalary() {
		return salary;
	}


	public void setSalary(BigDecimal d) {
		this.salary = d;
	}


	public String getDepartment_id() {
		return department_id;
	}


	public void setDepartment_id(String department_id) {
		this.department_id = department_id;
	}


	@Override
	public String toString() {
		return "EmployeeVO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", phone=" + phone + ", dateOfBirth=" + dateOfBirth + ", hire_date=" + hire_date + ", job_id="
				+ job_id + ", salary=" + salary + ",department_id="
				+ department_id + "]";
	}


}