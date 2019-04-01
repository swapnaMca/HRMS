<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">

<spring:url value="/resources/style.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />

<spring:url value="/resources/tableDecor.css" var="tableCss" />
<link href="${tableCss}" rel="stylesheet" />

<link href="${pageContext.request.contextPath}/resources/Tabs.css"
    rel="stylesheet">

<script src="${pageContext.request.contextPath}/js/Tabs.js"></script>
</head>
<body>


<div class="tab">
  <button class="tablinks" onclick="openTab(event, 'EmployeeDetails')" id="defaultOpen">Employee Details</button>
  <button class="tablinks" onclick="openTab(event, 'Login')">Login</button>
  <button class="tablinks" onclick="openTab(event, 'Training')">Training</button>
</div>
<c:url var="addAction" value="/Admin/saveEmployee" ></c:url>
<form:form action="${addAction}"  method="post" enctype="multipart/form-data" modelAttribute="employeeVO">
<div id="EmployeeDetails" class="tabcontent">
<table align="center" >
  <span onclick="this.parentElement.style.display='none'" class="topright">&times</span>

<th align ="center" style="color:#0E4679">Employee Details</th>
<tr>
<!-- <td>Employee ID</td> --><td><form:hidden path="id" cssClass="focus1" /></td>
<td><form:errors path="id" cssClass="error"/></td></tr>
<tr>
<td>firstName</td><td><form:input path="firstName" cssClass="focus1"/></td>
<td><form:errors path="firstName" cssClass="error" /></td>
</tr>
<tr>
<td>LastName(*)</td><td><form:input path="lastName" cssClass="focus1"/></td>
<td><form:errors path="lastName" cssClass="error"/></td>
</tr>

<tr>
<td>Phone</td><td><form:input path="phone" cssClass="focus1"/></td>
<td><form:errors path="phone" cssClass="error"/></td>
</tr>
<tr>
<td>DOB</td><td><form:input type="date" path="dateOfBirth" cssClass="focus1"/></td>
<td><form:errors path="dateOfBirth" cssClass="error"/></td>
</tr>

<tr>
<td>hire_date</td><td><form:input type="date"  path="hire_date" cssClass="focus1"/></td>
<td><form:errors path="hire_date" cssClass="error"/></td>
</tr>
<tr>
<td>JobId</td><td><form:input path="job_id" cssClass="focus1"/></td>
<td><form:errors path="job_id" cssClass="error"/></td>
</tr>
<tr>
<td>salary</td><td><form:input path="salary" cssClass="focus1"/></td>
<td><form:errors path="salary" cssClass="error"/></td>
</tr>



<tr>
<td>Department Id(*)</td><td><form:select path="department_id" cssClass="focus1">
 <form:option value="NONE" label="--- Select ---"/>
<form:options items="${DropDownList}"/>

</form:select> </td>
<td><form:errors path="department_id" cssClass="error"/></td>
</tr>
</table>
</div>

<div id="Login" class="tabcontent">
<table align="center" >
  <span onclick="this.parentElement.style.display='none'" class="topright">&times</span>
  <tr>
<td>UserName(*)</td><td><form:input path="employeeLogin.userName" cssClass="focus1"/></td>
<td><form:errors path="employeeLogin.userName" cssClass="error"/></td>
</tr>
<tr>
<td>Password</td><td><form:password path="employeeLogin.password" cssClass="focus1"/></td>
<td><form:errors path="employeeLogin.password" cssClass="error"/></td>
</tr>
<tr>
<td>Role</td><td><form:input path="employeeLogin.role" cssClass="focus1"/></td>
<td><form:errors path="employeeLogin.role" cssClass="error"/></td>
</tr>
<tr><td>Image</td>
<td><img width="100" height="100" src='${pageContext.request.contextPath}/Admin/getEmployeePhoto/${id}'/></td>
</tr>


</table>

</div>

<div id="Training" class="tabcontent">
<table align="center" >
  <span onclick="this.parentElement.style.display='none'" class="topright">&times</span>
  <tr>
 <td></td><td><form:hidden path="employeeTraining.Id" cssClass="focus1"/></td>
<td><form:errors path="employeeTraining.Id" cssClass="error"/></td>
 </tr>
 <tr>
 
 <td>Skills</td><td><form:input path="employeeTraining.skills" cssClass="focus1"/></td>
<td><form:errors path="employeeTraining.skills" cssClass="error"/></td>
 </tr>
 
 <tr>
 <td>Training</td><td><form:input path="employeeTraining.training" cssClass="focus1"/></td>
<td><form:errors path="employeeTraining.training" cssClass="error"/></td>
 </tr>
  <tr>
 <td>Bond</td><td><form:input path="employeeTraining.bond" cssClass="focus1"/></td>
<td><form:errors path="employeeTraining.bond" cssClass="error"/></td>
 </tr>
 <tr>
 <td>ProjectRequested</td><td><form:input path="employeeTraining.projectReqt" cssClass="focus1"/></td>
<td><form:errors path="employeeTraining.projectReqt" cssClass="error"/></td>
 </tr>
 <tr>
<td><input type="submit"/></td>

</tr>
 </table>
</div>
</form:form>
<c:if test="${!empty listEmployees}">
	<h3>Employees List</h3>


<div class="pagination">
	<table class="tg" border="#7d69ab">
	<tr class="employeetHeader">
		<th>ID</th>
		<th width="80">FirstName</th>
		<th width="120">LastName</th>
		<th width="120">Phone</th>
		<th width="120">DOB</th>
		<th width="120">HireDate</th>
		<th width="120">JobId</th>
			<th width="120">Salary</th>
			<th width="120">DepartmentId</th>
		<th width="80">Role</th>
		<th width="120">Email</th>
		<th width="120">Photo</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listEmployees}" var="employee">
	
		<tr class="employeeTR">
			<td  width="80">${employee.id}</td>
				<td width="120">${employee.firstName}</td>
				<td width="120">${employee.lastName}</td>
				<td width="120">${employee.phone}</td>
				<td width="120">${employee.dateOfBirth}</td>
				<td width="120">${employee.hire_date}</td>
				<td width="120">${employee.job_id}</td>
				<td width="120">${employee.salary}</td> 
				<td width="120">${employee.department_id}</td>
				<td width="120">${employee.employeeLogin.role}</td>
				<td width="120">${employee.employeeLogin.userName}</td>
				<td width="120">
			
				 <img width="100" height="100" src='${pageContext.request.contextPath}/Admin/getEmployeePhoto/${employee.id}'/>
				 </td>
			<td width="60"><a href="<c:url value='/Admin/editEmployee/${employee.id}' />" >Edit</a></td>
			<td width="60"><a href="<c:url value='/Admin/removeEmployee/${employee.id}' />" >Delete</a></td>
		</tr>
	
	</c:forEach>
	</table>
	</div>
</c:if>
   
</body>
</html> 
