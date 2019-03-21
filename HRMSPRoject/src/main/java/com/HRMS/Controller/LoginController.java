package com.HRMS.Controller;

import java.io.UnsupportedEncodingException;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import  java.util.Base64;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.HRMS.Model.EmployeeVO;
import com.HRMS.Service.LoginService;
import com.HRMS.util.HRMSRole;


@Controller
@SessionAttributes("login")
public class LoginController {
	private Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	LoginService loginService;

	private Validator validator;
	
	
	
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	
	
	
	@RequestMapping("Login")
	public ModelAndView showLoginPage(Model model)
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("employeeVO", new EmployeeVO());
		modelAndView.setViewName("AdminLogin");
		return modelAndView;
	}
	
	@RequestMapping("LogOut")
	public ModelAndView showLogOutPage(Model model)
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("employeeVO", new EmployeeVO());
		modelAndView.setViewName("AdminLogin");
		return modelAndView;
	}
	@RequestMapping("validUser")
	public ModelAndView validateUser(@ModelAttribute("employeeVO") @Valid EmployeeVO employeeVO,
			BindingResult result,
			@RequestParam("employeeLogin.userName") String email,
			@RequestParam("employeeLogin.password") String password,
			Model model,HttpSession session) throws UnsupportedEncodingException
	{
		ModelAndView modelAndView = new ModelAndView();
		
        if(result.hasErrors())
    	{
        	System.out.println("HASResult");
        	modelAndView.setViewName("AdminLogin");
        	
    	}
		else
		{
		System.out.println("LoginController"+email+""+password);
		EmployeeVO employee = loginService.validateUser(email, password);
		if(employee!=null)
		{
			System.out.println("IN IF ********"+employee.getEmployeeLogin().getRole());
			//if(employee.getRole().equalsIgnoreCase(HRMSRole.ADMIN.toString()))
			if(employee.getEmployeeLogin().getRole().equalsIgnoreCase(HRMSRole.ADMIN.toString()))
			{
				modelAndView.setViewName("HRHomePage");

			}
			else
			{
				
				modelAndView.setViewName("EmployeeHomePage");
				
			}
			if(employee.getEmployeeLogin().getPhoto()!=null)
			{
				
			//java8 has Base64
				byte[] encodeBase64 =Base64.getEncoder().encode(employee.getEmployeeLogin().getPhoto());
			    String base64Encoded = new String(encodeBase64, "UTF-8");
			    session.setAttribute("userImage", base64Encoded );
			}
		
			model.addAttribute(employee);
			modelAndView.addObject("user", employee);
			modelAndView.addObject("login", employee);
			
        	
		}
		else
			
		{
			modelAndView.setViewName("AdminLogin");
        	
		}
		}
        return modelAndView;
		
	}

}
