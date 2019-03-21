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

</head><spring:url value="/resources/tableDecor.css" var="tableCss" />
<link href="${tableCss}" rel="stylesheet" />
<body>

<c:url var="addAction" value="/Admin/saveEmployee" ></c:url>

<form:form action="${addAction}" method="post" enctype="multipart/form-data" modelAttribute="employeeVO">
<div id="addEmployeeDiv">

<table align="center" >
<th><p style="color:#0E4679">Employee Details</p></th>
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
<td>DOB</td><td><form:input path="dateOfBirth" cssClass="focus1"/></td>
<td><form:errors path="dateOfBirth" cssClass="error"/></td>
</tr>

<tr>
<td>hire_date</td><td><form:input path="hire_date" cssClass="focus1"/></td>
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
<form:options items="${DepartmentList}"/>

</form:select> </td>
<td><form:errors path="department_id" cssClass="error"/></td>
</tr>
<br><br>
<th><p style="color:#0E4679">Login Details</p></th>
<tr>
<td><td><form:hidden path="employeeLogin.id" cssClass="focus1"/></td>
<td><form:errors path="employeeLogin.id" cssClass="error"/></td>
</tr>
<tr>
<td>UserName(*)</td><td><form:input path="employeeLogin.userName" cssClass="focus1"  /></td>
<td><form:errors path="employeeLogin.userName" cssClass="error"/></td>
</tr>
<%-- <tr>
<td>Password</td><td><form:password path="employeeLogin.password" cssClass="focus1" /></td>
<td><form:errors path="employeeLogin.password" cssClass="error"/></td>
</tr> --%>
<%-- <tr>
<td>Role</td><td><form:input path="employeeLogin.role" cssClass="focus1"/></td>
<td><form:errors path="employeeLogin.role" cssClass="error"/></td>
</tr> --%>
<!-- @DynamicUpdate -->
<tr><td>Upload Image</td>
 <td><input type="file" name="image" id="image"/></td>
</tr>
<tr>
		<td colspan="2">
			<c:if test="${!empty employeeVO.firstName}">
				<input type="submit"
					value="<spring:message text="Edit Employee"/>" />
			</c:if>
			<c:if test="${empty employeeVO.firstName}">
				<input type="submit"
					value="<spring:message text="Add Employee"/>" />
			</c:if>
		</td>
	</tr>

</table>

</div>	
	</form:form> 
<c:if test="${!empty listEmployees}">
	<h3>Employees List</h3>


<div class="pagination">
	<table class="tg">
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