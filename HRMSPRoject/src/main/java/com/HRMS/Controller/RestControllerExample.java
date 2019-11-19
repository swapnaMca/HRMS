package com.HRMS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.HRMS.Model.EmployeeVO;
import com.HRMS.Model.Projects;
import com.HRMS.Service.AdminService;

@RestController
public class RestControllerExample {
	
	@Autowired
	private AdminService service;
	
@RequestMapping(value="/employees",produces="application/json",method=RequestMethod.GET)
public List<EmployeeVO> getEmployeeDetails()
{
	System.out.println("getEmployeeDetails***************"+service.listPersons().get(0).getId());
	return service.listPersons();
}

@RequestMapping(value="/projectListTest",produces="application/json",method=RequestMethod.GET)
public ResponseEntity<List<Projects>> getEmployee()
	{
	List<Projects> list= service.projectsList();
		System.out.println("getEmployeeDetail((((((((((((((((((");

		return ResponseEntity.ok().body(list);
	}

}
