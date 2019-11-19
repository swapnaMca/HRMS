package com.HRMS.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.HRMS.Model.DepartmentVO;
import com.HRMS.Model.EmployeeVO;
import com.HRMS.Model.EmployeeVO_Login;
import com.HRMS.Model.Employee_Leaves;
import com.HRMS.Model.Leaves;
import com.HRMS.Service.EmployeeService;


@Controller
public class EmployeeController {

	@Autowired
	@Qualifier("employeeService")
	EmployeeService employeeService;
	
	
	 	
	 	
	 	@RequestMapping("/LeaveRequest")
		public String LeaveRequest(Model model) {
			model.addAttribute("employeeLeave", new Employee_Leaves());
		
			model.addAttribute("LeavesList",this.employeeService.getAllLeaves());
			return "leaveRequest";
		}
	 	@RequestMapping("/sendLeaveRequest")
		public String sendLeaveRequest(@ModelAttribute("employeeLeave") Employee_Leaves employeeLeave,Model model)
	 	{
	 		List<Employee_Leaves> LeaveList=this.employeeService.getEmployeeLeavesById(employeeLeave.getEmpId());
	 		if(LeaveList.size()!=0)
	 		{
	 			//last applied leaves
	 			System.out.println("from employee Controle"+LeaveList.size()+"......"+LeaveList.get(LeaveList.size()-1).getAvilableLeaves());
	 			employeeLeave.setAvilableLeaves(LeaveList.get(LeaveList.size()-2).getAvilableLeaves());
	 			System.out.println("IN IF LeaveList"+LeaveList.get(0).getAvilableLeaves());
	 		}
	 		else
	 		{
	 			employeeLeave.setAvilableLeaves(1);
	 		}
 			employeeService.sendLeaveRequest(employeeLeave);

	 		model.addAttribute("LeavesList",this.employeeService.getAllLeaves());
			model.addAttribute("Success","Request Send Successfully");
	 		return "leaveRequest";
	 		/*employeeService.sendLeaveRequest(employeeLeave);
		model.addAttribute("LeavesList",this.employeeService.getAllLeaves());
		model.addAttribute("Success","Request Send Successfully");
			return "leaveRequest";*/
		}
	 	@RequestMapping("/checkEmployeeLeaveStatus/{id}")
	 	public String viewLeaveStatus(@PathVariable("id") int empId,Model model) 
	 	{
	 		List<Employee_Leaves> appliedLeaves=this.employeeService.getEmployeeLeavesById(empId);
	 		model.addAttribute("LeaveStatus", appliedLeaves);
	 		return "viewEmployeeLeaveStatus";
	 	}
	 /*	@RequestMapping("/employee1-1")
		public String addEmployeeAndRole(@ModelAttribute("employee") EmployeeVO employeeVO1,Model model)
		{
		
		//1-1 bidirectinal w/o joinColumn
	 		EmployeeVO employeeVO=new EmployeeVO ();
			employeeVO.setFirstName("Hello");
			employeeVO.setLastName("checking");
			//employeeVO.setEmail("Take@gmail.com");
			employeeVO.setDateOfBirth("2013-08-18");
			employeeVO.setHire_date("2013-08-18");
			employeeVO.setDepartment_id("1");
			System.out.println("**********"+employeeVO.getFirstName());
			EmployeeVO_Login login=new EmployeeVO_Login();
			
			login.setConfirmPassword("password");
			//login.setUserName(employeeVO.getEmail());
			login.setPassword("password");
			login.setRole("Role");
			employeeVO.setEmployeeLogin(login);
			employeeVO.getEmployeeLogin().setEmployeeVO(employeeVO);
			
			
			this.employeeService.addEmployee(employeeVO);
			
			return "helloWorld";
		}
	 	
	 	@RequestMapping("/UpdatePassword")
		public String changePassword(@PathVariable("id") int id,@ModelAttribute("user") EmployeeVO employeeVO,Model model) {
	 		System.out.println("employeeVO...."+employeeVO.getId());
			model.addAttribute("user", new EmployeeVO());
			return "changePasswordPage";
		}
	 	@RequestMapping("/AddLeave")
		public String addLeave(Model model) {
			model.addAttribute("leaves", new Leaves());
			Leaves l =new Leaves();
			l.setLeaveName("Casual");
			l.setDays(12);
			this.employeeService.addLeave(l);
			return "viewEmployeeProfile";
		}
	 	EmployeeVO_Login2 employeeLogin=new EmployeeVO_Login2();
		employeeLogin.setFirstName("checking");
		employeeLogin.setPassword("checking");
		employeeLogin.setRole("checking");
		EmployeeVO2 employee= employeeVO.getEmployeeLogin().getEmployee();
		
		 if (employee == null)
			 employee = new EmployeeVO2(employeeLogin); 
		
		 System.out.println("((((((((((((("+employee.getFirstName());
		 */
}
