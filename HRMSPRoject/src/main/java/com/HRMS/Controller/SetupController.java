package com.HRMS.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.HRMS.Model.DepartmentVO;
import com.HRMS.Model.Projects;
import com.HRMS.Service.SetupService;

@Controller
@RequestMapping("/Setup")
public class SetupController {
	
	@Autowired
	SetupService setupService;
	
	@RequestMapping("/Setup")
	public ModelAndView LoadSetupPage()
	{
		ModelAndView modelAndview =new ModelAndView();
		modelAndview.setViewName("setupHomePage");
		return modelAndview;
		
		
	}
	@RequestMapping("/AddProjectRequest")
	public ModelAndView loadProjectRegisterPage(@ModelAttribute("projects") Projects projects ,Model model )
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("projects", new Projects());
		modelAndView.setViewName("AddProjectRequest");
		return modelAndView;
	}
	@RequestMapping("/addProjects")
	public String saveProject(@Valid @ModelAttribute("projects") Projects projects,BindingResult result,Model model )
	{
		System.out.println("*********************");
		if(result.hasErrors())
		{
			return "AddProjectRequest";
		}
		else
		{

	
		this.setupService.addProjects(projects);
		model.addAttribute("suceess", "Project"+" "+projects.getProjectName()+" Added"+" SuccessFully");
		}
		
			return "redirect:/Setup/AddProjectRequest";
	}
	@RequestMapping("/departments")
	public String loadDepartment(@ModelAttribute("departmentVO") DepartmentVO departmentVO,Model model) {
		model.addAttribute("departmentVO", departmentVO);
		model.addAttribute("DepartmentList", this.setupService.listDepartments());
		 
	   List<String> l=new ArrayList<String>();
	   l.add("IT");
	   l.add("HR");
	   model.addAttribute("list",l);
		return "Department-form";
	}
 	@RequestMapping("/addDepartments")
	public String addDepartment(@ModelAttribute("departmentVO") DepartmentVO departmentVO,Model model) {
 		this.setupService.addDepartment(departmentVO);
 		model.addAttribute("DepartmentList", this.setupService.listDepartments());
		return "Department-form";
	}
}
