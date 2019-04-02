package com.HRMS.Controller;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.HRMS.Model.EmployeeVO;
import com.HRMS.Model.EmployeeVO_Login;
import com.HRMS.Service.EmployeeService;
import com.HRMS.util.HRMSRole;

@Controller
public class CommonController {
	@Autowired
	@Qualifier("employeeService")
	EmployeeService employeeService;
	
	@RequestMapping("/viewProfile/{id}/{role}")
	  public String getEmployeeById(@PathVariable("id") int id,@PathVariable("role") String role,@ModelAttribute("user") EmployeeVO employeeVO, Model model){
	String viewName="";
		if(role.equalsIgnoreCase(HRMSRole.ADMIN.toString()))
			viewName="viewHRProfile";
	else
		viewName="viewEmployeeProfile";
		
	        return viewName;
  }
	
	@RequestMapping(value={"/LoadChangePassword/{role}","/changeProfilePic/{role}"})
	public ModelAndView loadChangePassword(@PathVariable("role") String role,HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("employeeLogin", new EmployeeVO_Login());
		
		String requestUrl=request.getServletPath();
		
		System.out.println("requestUrl...."+requestUrl+"******"+role);
		/* HR has change password and profile pick ,to seperate the menu of two modules(different views)*/
		if(role.equalsIgnoreCase(HRMSRole.ADMIN.toString()))
		{
			if(requestUrl.equals("/LoadChangePassword/"+role))
				modelAndView.setViewName("HRchangePasswordPage");
				else
					modelAndView.setViewName("HRchangeProfilePic");	
			
		}
		/* User has change password and profile pick ,to seperate the menu of two modules(different views)*/

		else
		{
		if(requestUrl.equals("/LoadChangePassword/"+role))
		modelAndView.setViewName("changePasswordPage");
		else
			modelAndView.setViewName("changeProfilePic");
		}
		return modelAndView;
	}
	@RequestMapping("/UpdatePassword/{id}")
	public ModelAndView updatePassword(@Valid @ModelAttribute("employeeLogin") EmployeeVO_Login employeeLogin,BindingResult result,
			@PathVariable("id") int id) {
		
		System.out.println("employeeLogin.getRole()"+employeeLogin.getRole());
		ModelAndView modelAndView = new ModelAndView();
		if (result.hasErrors()) {
			modelAndView.setViewName("changePasswordPage");
		}
		else
		{
			
				if(employeeLogin.getPassword().equalsIgnoreCase(employeeLogin.getConfirmPassword()))
				{
					employeeService.updateEmployeePassword(employeeLogin);
					modelAndView.addObject("PasswordFlag", employeeLogin.getUserName()+"Password Updated"+" Successfully");
					
				}
				else
				{
					result.rejectValue("confirmPassword", "password.MisMatch");
					//modelAndView.setViewName("changePasswordPage");
				}
	 		
		}
		/*return view if role is admin*/
		if(employeeLogin.getRole().equalsIgnoreCase(HRMSRole.ADMIN.toString()))
		{
			modelAndView.setViewName("HRchangePasswordPage");
		}
		/*return view if role is user*/
		else
		{
			modelAndView.setViewName("changePasswordPage");

		}
		
	
		return modelAndView;
	}
	@RequestMapping("/UpdateProfilePic/{id}/{role}")
	public ModelAndView UpdateProfilePic(@Valid @ModelAttribute("employeeLogin") EmployeeVO_Login employeeLogin,BindingResult result,
			@PathVariable("id") int id,@PathVariable("role") String role,@RequestParam("image") MultipartFile photo,HttpSession session) throws IOException {
		
		
		ModelAndView modelAndView = new ModelAndView();
		employeeLogin.setPhoto(photo.getBytes());
		employeeService.updateEmployeeProfilePic(employeeLogin);//for update of any column
		EmployeeVO employee=employeeService.getEmployeeById(id);
		if(employee.getEmployeeLogin().getPhoto()!=null)
		{
			
		//java8 has Base64
			byte[] encodeBase64 =Base64.getEncoder().encode(employee.getEmployeeLogin().getPhoto());
		    String base64Encoded = new String(encodeBase64, "UTF-8");
		    session.setAttribute("userImage", base64Encoded );
		}
		if(role.equalsIgnoreCase(HRMSRole.ADMIN.toString()))
			modelAndView.setViewName("HRchangeProfilePic");
		else
		modelAndView.setViewName("changeProfilePic");
		modelAndView.addObject("successFlag", "Dear "+employeeLogin.getUserName()+" Profile Pic  Updated"+" Successfully");

		return modelAndView;
	}

}
