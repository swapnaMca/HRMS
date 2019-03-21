<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<spring:url value="/resources/style.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />
<spring:url value="/resources/tableDecor.css" var="tableCss" />
<link href="${tableCss}" rel="stylesheet" />
</head>
<body>


<c:if test="${!empty listEmployees}">
	<h3>Employees List</h3>

<div class="center">
<div class="pagination">
	<table class="tg" border=1>
	<tr class="employeetHeader">
		<th>ID</th>
		<th width="80">FirstName</th>
		<th width="120">LastName</th>
		<th width="120">Email</th>
		<th width="120">Phone</th>
		<th width="120">DOB</th>
		<th width="120">HireDate</th>
		<th width="120">JobId</th>
			<th width="120">Salary</th>
			<th width="120">DepartmentId</th>
		<th width="120">Role</th>
		<th width="120">Image</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listEmployees}" var="employee">
	
		<tr class="employeeTR">
			<td  width="80">${employee.id}</td>
				<td width="120">${employee.firstName}</td>
				<td width="120">${employee.lastName}</td>
				<td width="120">${employee.employeeLogin.userName}</td>
				<td width="120">${employee.phone}</td>
				<td width="120">${employee.dateOfBirth}</td>
				<td width="120">${employee.hire_date}</td>
				<td width="120">${employee.job_id}</td>
				<td width="120">${employee.salary}</td> 
				<td width="120">${employee.department_id}</td>
				<td width="120">${employee.employeeLogin.role}</td><%-- <img src="data:image/jpeg;base64,${userImage}" /> --%>
	
 <td>

 				 <img width="100" height="100" src='${pageContext.request.contextPath}/Admin/getEmployeePhoto/${employee.id}'/>
 
 
 </td>
			<td width="60"><a href="<c:url value='/Admin/editEmployee/${employee.id}' />" >Edit</a></td>
			<td width="60"><a href="<c:url value='/Admin/removeEmployee/${employee.id}' />" >Delete</a></td>
		</tr>
	
	</c:forEach>
	</table>
	</div>
	</div>
</c:if>
</body>
</html>