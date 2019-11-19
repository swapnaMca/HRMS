package com.HRMS.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.HRMS.Model.DepartmentVO;
import com.HRMS.Service.EmployeeService;
@RestController
public class DepartmentController {
	
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value ="/restDepartment" ,method = RequestMethod.POST, headers = "Accept=application/json")
   public void save(@RequestBody DepartmentVO departmentVO) 
   {
       this.employeeService.addDepartment(departmentVO);
     
   }

	/*@RequestMapping("/departments")
	public String loadDepartment(@ModelAttribute("departmentVO") DepartmentVO departmentVO,Model model) {
		model.addAttribute("departmentVO", departmentVO);
		model.addAttribute("DepartmentList", this.employeeService.listDepartments());
		 
	   List<String> l=new ArrayList<String>();
	   l.add("IT");
	   l.add("HR");
	   model.addAttribute("list",l);
		return "Department-form";
	}
 	@RequestMapping("/addDepartments")
	public String addDepartment(@ModelAttribute("departmentVO") DepartmentVO departmentVO,Model model) {
 		this.employeeService.addDepartment(departmentVO);
 		model.addAttribute("DepartmentList", this.employeeService.listDepartments());
		return "Department-form";
	}*/
}
