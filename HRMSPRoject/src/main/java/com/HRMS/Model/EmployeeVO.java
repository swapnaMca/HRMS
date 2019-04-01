package com.HRMS.Model;



import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;


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
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;
	
	//@NotEmpty(message="is Required")
	@Column(name="hire_date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date hire_date;
	
	//@NotEmpty(message="is Required")
	@Column(name="job_id")
	private Integer job_id;
	
	//@NotEmpty(message="is Required")
	@Column(name="salary" , precision = 8, scale = 2)
	private BigDecimal  salary;
	
	
	
	
	//@NotEmpty(message="is Required")
	@Column(name="DEPT_Id")
	private String department_id;
	
	/* Primary key column join*/
	@OneToOne(mappedBy="employeeVO" ,cascade=CascadeType.ALL)
	private EmployeeVO_Login employeeLogin;
	
	/*column join*/
	@OneToOne(mappedBy="employeeVO" ,cascade=CascadeType.ALL)
	private EmployeeVO_Training employeeTraining;
	
	
	
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


	public EmployeeVO_Training getEmployeeTraining() {
		return employeeTraining;
	}


	public void setEmployeeTraining(EmployeeVO_Training employeeTraining) {
		this.employeeTraining = employeeTraining;
	}


	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public Date getHire_date() {
		return hire_date;
	}


	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}


	


	

}