package com.HRMS.Model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="hrms_login")
@DynamicInsert
public class EmployeeVO_Login implements Serializable 
{
    @Id
	@Column(name="ID")
	@GeneratedValue(generator="gen")
    @GenericGenerator(name="gen",strategy="foreign",parameters=@Parameter(name="property",value="employeeVO"))
    private Integer id;
	
    
	@Column(name="userName",length=50)
	private String userName;
	
	
	@Column(name="password",length=50)
	private String password;
	
  
	@Column(name="confirmPassword",length=50)
	private String confirmPassword;
	
  
	@Column(name="role",length=50)
	private String role;
	
	@Lob
	 @Column(name="photo")
	private  byte[] photo;
	
	
	public byte[] getPhoto() {
		return photo;
	}


	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	
	@OneToOne(cascade=CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private EmployeeVO employeeVO;
	

	

	public EmployeeVO_Login() {
		
	}

	/*public EmployeeVO_Login2(EmployeeVO2 employeeVO) {
		 this.employee = employeeVO;
		 employee.setEmployeeLogin(this);
	}*/

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	

	public EmployeeVO getEmployeeVO() {
		return employeeVO;
	}

	public void setEmployeeVO(EmployeeVO employeeVO) {
		this.employeeVO = employeeVO;
	}

	@Override
	public String toString() {
		return "EmployeeVO_Login [id=" + id + ", userName=" + userName + ", password=" + password + ", confirmPassword="
				+ confirmPassword + ", role=" + role + "]";
	}

	
}
