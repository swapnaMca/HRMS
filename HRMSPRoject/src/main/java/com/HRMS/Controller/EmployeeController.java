package com.HRMS.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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
	
	
	 	
	 	@RequestMapping("/viewProfile/{id}")
		  public String getEmployeeById(@PathVariable("id") int id,@ModelAttribute("user") EmployeeVO employeeVO, Model model){
	 	
	  	        return "viewEmployeeProfile";
	    }
	 	/*@RequestMapping("/LoadchangePassword/{id}")
		public String changePassword(@PathVariable("id") int id,@ModelAttribute("user") EmployeeVO employeeVO,Model model) {
	 		System.out.println("employeeVO...."+employeeVO.getId());
			model.addAttribute("user", new EmployeeVO());
			return "changePasswordPage";
		}*/
	 	@RequestMapping("/viewProfile")
		  public String getEmployeeProfile(){
	  	        return "viewEmployeeProfile";
	    }
	 	@RequestMapping(value={"/LoadChangePassword","/changeProfilePic"})
		public ModelAndView loadChangePassword(HttpServletRequest request) {
	 		ModelAndView modelAndView = new ModelAndView();
	 		modelAndView.addObject("employeeLogin", new EmployeeVO_Login());
	 		
	 		String requestUrl=request.getServletPath();
	 		
	 		if(requestUrl.equals("/LoadChangePassword"))
	 		modelAndView.setViewName("changePasswordPage");
	 		else
	 			modelAndView.setViewName("changeProfilePic");
			return modelAndView;
		}
	 	@RequestMapping("/UpdatePassword/{id}")
		public ModelAndView updatePassword(@Valid @ModelAttribute("employeeLogin") EmployeeVO_Login employeeLogin,BindingResult result,
				@PathVariable("id") int id) {
	 		
	 		
	 		ModelAndView modelAndView = new ModelAndView();
	 		if (result.hasErrors()) {
	 			System.out.println("**********444444444**********"+result.getFieldError());
	 			modelAndView.setViewName("changePasswordPage");
	 		}
	 		else
	 		{
	 			
	 				if(employeeLogin.getPassword().equalsIgnoreCase(employeeLogin.getConfirmPassword()))
	 				{
	 					System.out.println("password and confirm are equal"+employeeLogin.getConfirmPassword()+""+employeeLogin.getId());
	 					employeeService.updateEmployeePassword(employeeLogin);
	 					modelAndView.addObject("PasswordFlag", employeeLogin.getUserName()+"Password Updated"+" Successfully");
	 					modelAndView.setViewName("changePasswordPage");
	 				}
	 				else
	 				{
	 					result.rejectValue("confirmPassword", "password.MisMatch");
	 					modelAndView.setViewName("changePasswordPage");
	 				}
		 		
	 		}
	 		
	 	
			return modelAndView;
		}
	 	@RequestMapping("/UpdateProfilePic/{id}")
		public ModelAndView UpdateProfilePic(@Valid @ModelAttribute("employeeLogin") EmployeeVO_Login employeeLogin,BindingResult result,
				@PathVariable("id") int id,@RequestParam("image") MultipartFile photo) throws IOException {
	 		
	 		
	 		ModelAndView modelAndView = new ModelAndView();
	 		employeeLogin.setPhoto(photo.getBytes());
	 		employeeService.updateEmployeeProfilePic(employeeLogin);//for update of any column
	 		modelAndView.addObject("successFlag", employeeLogin.getUserName()+"Profile Pic  Updated"+" Successfully");
	 		modelAndView.setViewName("changeProfilePic");
	 		return modelAndView;
	 	}
	 	@RequestMapping("/LeaveRequest")
		public String LeaveRequest(Model model) {
			model.addAttribute("employeeLeave", new Employee_Leaves());
			List<Leaves> list=this.employeeService.getAllLeaves();
			System.out.println(list);
			model.addAttribute("LeavesList",this.employeeService.getAllLeaves());
			return "leaveRequest";
		}
	 	@RequestMapping("/sendLeaveRequest")
		public String sendLeaveRequest(@ModelAttribute("employeeLeave") Employee_Leaves employeeLeave,Model model) {
	 	ModelAndView modelandView=new ModelAndView();
	 	System.out.println("employeeLeave"+employeeLeave.getLeaves().getLeaveId());
	 	employeeService.sendLeaveRequest(employeeLeave);
	 	model.addAttribute("Success","Request Send Successfully");
			return "leaveRequest";
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
