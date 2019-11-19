<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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

	<h3>Profile Details</h3>
<div class="col-sm-8 text-left"> 
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
			<th width="80">Role</th>
		
		
	</tr>
	
	
		<tr class="employeeTR">
			<td  width="80">${login.id}</td>
				<td width="120">${login.firstName}</td>
				<td width="120">${login.lastName}</td>
				<td width="120">${login.employeeLogin.userName}</td>
				<td width="120"><a href="<c:url value='/editEmployee/${login.id}' />" >${login.phone}</a></td>
				<td width="120">${login.dateOfBirth}</td>
				<td width="120">${login.hire_date}</td>
				<td width="120">${login.job_id}</td>
				<td width="120">${login.salary}</td> 
				<td width="120">${login.department_id}</td>
				<td width="120">${login.employeeLogin.role}</td>
			
		</tr>
	
	</table>
	</div>
	</div>
</div>
</body>
</html>