package com.HRMS.Controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.HRMS.Model.DepartmentVO;
import com.HRMS.Model.EmployeeVO;
import com.HRMS.Model.EmployeeVOImage;
import com.HRMS.Model.EmployeeVO_Login;
import com.HRMS.Model.EmployeeVO_Training;
import com.HRMS.Model.Employee_Leaves;
import com.HRMS.Model.Employee_Projects;
import com.HRMS.Model.Projects;
import com.HRMS.Service.AdminService;
import com.mysql.jdbc.Blob;


@Controller
@SessionAttributes("DropDownList")// to populate drop down list
@RequestMapping("/Admin")
public class AdminController {

	@Autowired
	AdminService adminService;

	@RequestMapping("/getEmployeesData")
	public ModelAndView loadEmployeePage(@ModelAttribute("employeeVO") EmployeeVO employeeVO, Model model) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("listEmployees", this.adminService.listPersons());
		modelAndView.setViewName("viewAndUpdateEmployee");
		return modelAndView;

	}

	@RequestMapping("/HRHome")
	public String loadHRHomePage() {

		return "HRHomePage";
	}
	@RequestMapping("/viewAdminProfile/{id}")
	  public String getEmployeeById(@PathVariable("id") int id,@ModelAttribute("user") EmployeeVO employeeVO, Model model){
	
	        return "viewHRProfile";
  }
	@RequestMapping("/RegisterEmployee")
	public String loadEmployeeRegisterPage(Model model) {
		List<DepartmentVO> dep = this.adminService.listDepartments();
		
		// for populationg existing Employee ids in drop down add list to seession
		Object[] departmentListToArray = this.adminService.listDepartments().toArray();
		List<Object> departmentArrayToList = Arrays.asList(departmentListToArray);
		model.addAttribute("DropDownList", GetDropDownData(departmentArrayToList, "department"));
		
		model.addAttribute("employeeVO", new EmployeeVO());
		return "EmployeeRegister";
	}

	@RequestMapping(value = { "/saveEmployee" }, method = RequestMethod.POST)
	public String saveEmployee(@Valid @ModelAttribute("employeeVO") EmployeeVO employeeVO, BindingResult result,
			@RequestParam("image") MultipartFile photo, Model model, HttpServletRequest request) throws IOException {
		String requestUrl = request.getServletPath();
		if (result.hasErrors()) {
			return "EmployeeRegister";
		} else {
			employeeVO.setEmployeeLogin(employeeVO.getEmployeeLogin());
			employeeVO.getEmployeeLogin().setEmployeeVO(employeeVO);
			employeeVO.getEmployeeLogin().setPhoto(photo.getBytes());

			//System.out.println("employeeVO.getEmployeeTraining()"+employeeVO.getEmployeeTraining());
			
			
			employeeVO.setEmployeeTraining(employeeVO.getEmployeeTraining());
			employeeVO.getEmployeeTraining().setEmployeeVO(employeeVO);
			
			this.adminService.addEmployee(employeeVO, "save");
			
		}

		return "redirect:/Admin/RegisterEmployee";
	}

	@RequestMapping(value = { "/updateEmployee" })
	public String updateEmployee(@Valid @ModelAttribute("employeeVO") EmployeeVO employeeVO, BindingResult result,
			Model model, HttpServletRequest request) throws IOException {

		EmployeeVO emp = new EmployeeVO();
		emp = this.adminService.getEmployeeById(employeeVO.getId());// always
																	// maintains
																	// image
																	// from db
																	// not null
																	// if u
																	// already
																	// isert
																	// into
																	// image
																	// bcoz
																	// dynamicupdate
																	// not
																	// working
		employeeVO.getEmployeeLogin().setPhoto(emp.getEmployeeLogin().getPhoto());

		employeeVO.setEmployeeLogin(employeeVO.getEmployeeLogin());
		employeeVO.getEmployeeLogin().setEmployeeVO(employeeVO);

		this.adminService.addEmployee(employeeVO, "update");
		return "redirect:/Admin/getEmployeesData";
	}

	@RequestMapping("/editEmployee/{id}")
	public String editEmployee(@PathVariable("id") int id, Model model) {
		EmployeeVO employeeVO = this.adminService.getEmployeeById(id);

		model.addAttribute("employeeVO", this.adminService.getEmployeeById(id));

		model.addAttribute("listEmployees", this.adminService.listPersons());

		
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
	public void getEmployeeImage(HttpServletResponse response, @PathVariable("id") int id) throws Exception 
	{
		response.setContentType("image/jpeg");

		EmployeeVO emp = this.adminService.getEmployeeById(id);

		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");

		response.getOutputStream().write(emp.getEmployeeLogin().getPhoto());

		response.getOutputStream().close();
	}
	
	@RequestMapping(value = {"/leaveHistoryRequestById","/leaveHistoryRequestByDate"})
	public ModelAndView LeaveHistoryById(@ModelAttribute("employeeLeave") Employee_Leaves employeeLeave,
			Model model, HttpServletRequest request) {
		ModelAndView modelandView = new ModelAndView();
		// for populationg existing Employee ids in drop down add list to seession
		Object[] employeeListToArray = this.adminService.listPersons().toArray();
		List<Object> employeeArrayToList = Arrays.asList(employeeListToArray);
		System.out.println("searchLeaveHistoryByIdsearchLeaveHistoryById");
		String requestUrl = request.getServletPath();
		
		modelandView.addObject("employeeLeave", new Employee_Leaves());
		modelandView.addObject("DropDownList",GetDropDownData(employeeArrayToList, "employeeId"));
		if(requestUrl.equals("/Admin/leaveHistoryRequestById"))
		modelandView.setViewName("leaveHistoryRequest");
		else
			modelandView.setViewName("leaveHistoryRequestByDate");
		return modelandView;
	}
	

	@RequestMapping("/LeaveHistoryById")
	public ModelAndView findLeaveHistory(@RequestParam("id") int id,
			@ModelAttribute("employeeLeave") Employee_Leaves employeeLeave, Model model) {

		ModelAndView modelandView = new ModelAndView();
		List<Employee_Leaves> history = this.adminService.leaveHistory(id);
		modelandView.addObject("history", history);
		modelandView.setViewName("leaveHistoryRequest");
		return modelandView;
	}
	@RequestMapping("/searchLeaveHistoryByDate")
	public ModelAndView findLeaveHistoryByDate(
			@ModelAttribute("employeeLeave") Employee_Leaves employeeLeave, Model model) {

		ModelAndView modelandView = new ModelAndView();
		String fromDate=employeeLeave.getStart_date().toString();
		String toDate=employeeLeave.getEnd_date().toString();
		String status=employeeLeave.getLeave_status();
		
		System.out.println("fromDate"+fromDate+">>>>>>"+employeeLeave.getStart_date());
		List<Employee_Leaves> history = this.adminService.leaveHistoryBydate(employeeLeave.getStart_date(),employeeLeave.getEnd_date(),status);
		modelandView.addObject("history", history);
		modelandView.setViewName("leaveHistoryRequestByDate");
		return modelandView;
	}
	@RequestMapping("/leaveHistoryStatus/{id}/{empId}/{SearchType}")
	public ModelAndView sendLeaveHistoryStatus(@PathVariable("id") int Id,
			@PathVariable("empId") int empId,
			@PathVariable("SearchType") String SearchType,
			@ModelAttribute("employeeLeave") Employee_Leaves employeeLeave, 
			Model model,HttpServletRequest request) {
		
		ModelAndView modelandView =  new ModelAndView();
		Employee_Leaves leaves=null;
		List<Employee_Leaves> list = this.adminService.leaveHistory(empId);
		Iterator<Employee_Leaves> iterator = list.iterator();
	    while (iterator.hasNext()) {
	    	leaves = iterator.next();
	        if (leaves.getId()==Id) {
	            break;
	        }
	    }
	    System.out.println("leaves from db...."+leaves);
		System.out.println("employeeLeaveemployeeLeaveemployeeLeave"+leaves.getTotal_days()+"...."+((leaves.getAvilableLeaves())-(leaves.getTotal_days())));
		System.out.println("employeeLeaveemployeeLeaveemployeeLeaveemployeeLeave"+(leaves.getAvilableLeaves()));
		if(employeeLeave.getLeave_status().equalsIgnoreCase("Accept"))
		{
			/*to identify the last list for available leaves*/
			System.out.println("**********"+list.get(list.size()-1).getAvilableLeaves());
			int avialble_leaves=list.get(list.size()-2).getAvilableLeaves();
			int total_days=leaves.getTotal_days();
			int remaining=avialble_leaves-total_days;
			System.out.println("avialble_leaves="+avialble_leaves);
			System.out.println("total_days="+total_days);
			System.out.println("remaining="+remaining);
			leaves.setAvilableLeaves(avialble_leaves-total_days);
			leaves.setLeave_status(employeeLeave.getLeave_status());
		}
		
		else
		{
			
			System.out.println("if(employeeLeave.ELSE...."+employeeLeave.getLeave_status());
			leaves.setAvilableLeaves((list.get(list.size()-2).getAvilableLeaves()));
			leaves.setLeave_status(employeeLeave.getLeave_status());

		}
		System.out.println("employeeLeave.setAvilableLeaves"+leaves.getAvilableLeaves());
		this.adminService.updateLeavesStatus(leaves,Id);
		List<Employee_Leaves> history = this.adminService.leaveHistory(empId);
		modelandView.addObject("history", history);
		modelandView.addObject("leaveStatusFlag","SuccessFully Send Leave Status");
	
if(SearchType.equalsIgnoreCase("ByDate"))
	modelandView.setViewName("leaveHistoryRequestByDate");
else
	modelandView.setViewName("leaveHistoryRequest");
			return modelandView;
	
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

		
		return "AssignProjectRequest";
	}
	
	@RequestMapping(value = "/getProjectNameById/{id}", method = RequestMethod.GET)
	public @ResponseBody String serachProjectNameById(@PathVariable("id") int id, Model model) {

		System.out.println("@PathVariable" + id);

		List<Projects> projectList = this.adminService.projectsList();
		String projectName = projectList.get(id - 1).getProjectName();

		return projectName;
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
