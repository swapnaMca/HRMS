package com.HRMS.Service;

import java.util.List;

import com.HRMS.Model.EmployeeVO;

public interface LoginService {
	
	public EmployeeVO AuthenticateUser(String uname,String password);
	public EmployeeVO validateUser(String uname,String password);
	

}
