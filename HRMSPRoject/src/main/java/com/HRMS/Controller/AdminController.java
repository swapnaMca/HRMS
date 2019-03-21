package com.HRMS.Controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.HRMS.Model.DepartmentVO;
import com.HRMS.Model.EmployeeVO;
import com.HRMS.Model.EmployeeVOImage;
import com.HRMS.Model.EmployeeVO_Login;
import com.HRMS.Model.Employee_Leaves;
import com.HRMS.Model.Employee_Projects;
import com.HRMS.Model.Projects;
import com.HRMS.Service.AdminService;
import com.mysql.jdbc.Blob;

@Controller
@RequestMapping("/Admin")
public class AdminController {

	@Autowired
	AdminService adminService;

	@RequestMapping("/getEmployeesData")
	public ModelAndView loadEmployeePage(@ModelAttribute("employeeVO") EmployeeVO employeeVO, Model model) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("listEmployees", this.adminService.listPersons());
		Object[] departmentListToArray = this.adminService.listDepartments().toArray();
		List<Object> departmentArrayToList = Arrays.asList(departmentListToArray);
		modelAndView.addObject("DepartmentList", GetDropDownData(departmentArrayToList, "department"));
		modelAndView.setViewName("viewAndUpdateEmployee");
		return modelAndView;

	}
	@RequestMapping("/HRHome")
	public String loadHRHomePage() {
		
		return "HRHomePage";
	}
	@RequestMapping("/RegisterEmployee")
	public String loadEmployeeRegisterPage(Model model) {
		List<DepartmentVO> dep = this.adminService.listDepartments();
		Object[] departmentListToArray = this.adminService.listDepartments().toArray();
		List<Object> departmentArrayToList = Arrays.asList(departmentListToArray);
		model.addAttribute("DepartmentList", GetDropDownData(departmentArrayToList, "department"));
		model.addAttribute("employeeVO", new EmployeeVO());
		return "EmployeeRegister";
	}

	@RequestMapping(value="/saveEmployee", method = RequestMethod.POST)
	public String saveEmployee(@Valid @ModelAttribute("employeeVO") EmployeeVO employeeVO, BindingResult result,
			@RequestParam("image") MultipartFile photo ,Model model) throws IOException{

		if (result.hasErrors()) {
			return "EmployeeRegister";
		} else {
			employeeVO.setEmployeeLogin(employeeVO.getEmployeeLogin());
			employeeVO.getEmployeeLogin().setEmployeeVO(employeeVO);
			System.out.println(photo.getContentType() + photo.getName() + "***********IMAGEEEEEEE" + "OBJECT"
					+ employeeVO.toString()+"^^^^^^^"+photo);
			System.out.println("isEmpty"+photo.isEmpty());
			//if(photo.getBytes()==null)
			employeeVO.getEmployeeLogin().setPhoto(photo.getBytes());
			this.adminService.addEmployee(employeeVO);
		}
		return "redirect:/Admin/getEmployeesData";
	}

	
	@RequestMapping("/editEmployee/{id}")
	public String editEmployee(@PathVariable("id") int id, Model model) {
		model.addAttribute("employeeVO", this.adminService.getEmployeeById(id));
		model.addAttribute("listEmployees", this.adminService.listPersons());

		Object[] departmentListToArray = this.adminService.listDepartments().toArray();
		List<Object> departmentArrayToList = Arrays.asList(departmentListToArray);
		model.addAttribute("DepartmentList", GetDropDownData(departmentArrayToList, "department"));
		return "viewAndUpdateEmployee";
	}

	@RequestMapping("/removeEmployee/{id}")
	public String removeEmployee(@PathVariable("id") int id) {

		this.adminService.removeEmployee(id);
		return "redirect:/Admin/getEmployeesData";
	}

	@RequestMapping("/viewAllEmployees")
	public String listPersons(Model model) throws UnsupportedEncodingException {
		model.addAttribute("employeeVO", new EmployeeVO());
		model.addAttribute("listEmployees", this.adminService.listPersons());
		
		return "viewAllEmployees";
	}
	@RequestMapping(value = "/getEmployeePhoto/{id}")
	public void getEmployeeImage(HttpServletResponse response, @PathVariable("id") int id) throws Exception {
		response.setContentType("image/jpeg");
		
		EmployeeVO emp = this.adminService.getEmployeeById(id);
		 
			 response.setContentType("image/jpeg, image/jpg, image/png, image/gif");

		    response.getOutputStream().write(emp.getEmployeeLogin().getPhoto());
		   
		    response.getOutputStream().close();
	}

	@RequestMapping(value = "/leaveHistoryRequest")
	public ModelAndView LeaveHistory(@ModelAttribute("employeeLeave") Employee_Leaves employeeLeave, Model model) {
		ModelAndView modelandView = new ModelAndView();
		Object[] employeeListToArray = this.adminService.listPersons().toArray();
		List<Object> employeeArrayToList = Arrays.asList(employeeListToArray);
		model.addAttribute("EmployeeList", GetDropDownData(employeeArrayToList, "employeeId"));

		modelandView.addObject("employeeLeave", new Employee_Leaves());

		modelandView.setViewName("leaveHistoryRequest");
		return modelandView;
	}

	@RequestMapping("/searchLeaveHistory")
	public ModelAndView findLeaveHistory(@RequestParam("id") int id,
			@ModelAttribute("employeeLeave") Employee_Leaves employeeLeave, Model model) {

		ModelAndView modelandView = new ModelAndView();
		List<Employee_Leaves> history = this.adminService.leaveHistory(id);
		Object[] employeeListToArray = this.adminService.listPersons().toArray();
		List<Object> employeeArrayToList = Arrays.asList(employeeListToArray);
		model.addAttribute("EmployeeList", GetDropDownData(employeeArrayToList, "employeeId"));

		modelandView.addObject("history", history);
		modelandView.setViewName("leaveHistoryRequest");
		return modelandView;
	}

	@RequestMapping(value = "/getProjectNameById/{id}", method = RequestMethod.GET)
	public @ResponseBody String serachProjectNameById(@PathVariable("id") int id, Model model) {

		System.out.println("@PathVariable" + id);

		List<Projects> projectList = this.adminService.projectsList();
		String projectName = projectList.get(id - 1).getProjectName();

		return projectName;
	}

	/* Project Module */
	@RequestMapping("/Projects")
	public ModelAndView LoadProject(Model model) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("employeeProjects", new Employee_Projects());
		modelAndView.setViewName("ProjectModule");
		return modelAndView;

	}

	@RequestMapping("/AssignProjectRequest")
	public String loadProjectRegisterPage(@ModelAttribute("employeeProjects") Employee_Projects employeeProjects,
			Model model) {
		// for getting Existing employees List
		Object[] employeeListToArray = this.adminService.listPersons().toArray();
		List<Object> employeeArrayToList = Arrays.asList(employeeListToArray);
		model.addAttribute("EmployeeList", GetDropDownData(employeeArrayToList, "employeeId"));

		// for getting Existing Projects List
		Object[] projectListToArray = this.adminService.projectsList().toArray();
		List<Object> projectArrayToList = Arrays.asList(projectListToArray);
		model.addAttribute("projectHandled", GetStringDropDownData(projectArrayToList, "projectName"));

		// for getting Existing Projects List
		Object[] projectIdListToArray = this.adminService.projectsList().toArray();
		List<Object> projectIdArrayToList = Arrays.asList(projectIdListToArray);
		model.addAttribute("projectIdList", GetDropDownData(projectIdArrayToList, "projectId"));

		//
		return "AssignProjectRequest";
	}

	@RequestMapping("/saveProject")
	public String saveProject(@Valid @ModelAttribute("employeeProjects") Employee_Projects employeeProjects,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "AssignProjectRequest";
		} else {
			employeeProjects.getProjectHandled();

			this.adminService.addProjects(employeeProjects);
		}
		return "redirect:/Admin/AssignProjectRequest";
	}

	public List<Integer> GetDropDownData(List<Object> list, String type) {
		List<Integer> dataList = new ArrayList<Integer>();

		List<String> dataList2 = new ArrayList<String>();

		if (type.equalsIgnoreCase("department")) {
			for (Object dept : list) {
				DepartmentVO department = (DepartmentVO) dept;
				dataList.add(department.getDepartmentId());
			}

		}
		if (type.equalsIgnoreCase("employeeId")) {
			for (Object emp : list) {
				EmployeeVO department = (EmployeeVO) emp;
				dataList.add(department.getId());
			}
		}

		if (type.equalsIgnoreCase("projectId")) {
			for (Object project : list) {
				Projects projects = (Projects) project;
				dataList.add(projects.getProjectId());
			}
		}

		return dataList;
	}

	public List<String> GetStringDropDownData(List<Object> list, String type) {

		List<String> dataList = new ArrayList<String>();

		if (type.equalsIgnoreCase("projectName")) {
			for (Object project : list) {
				Projects projects = (Projects) project;
				dataList.add(projects.getProjectName());
			}
		}

		return dataList;
	}

}
