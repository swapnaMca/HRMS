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

<c:url var="searchLeaveHistory" value="searchLeaveHistory" ></c:url>
<form:form action="${searchLeaveHistory}"  modelAttribute="employeeLeave">
<div id="addEmployeeDiv">
<table align="center" >
<tr>
<td>Employee ID</td>
<!-- <td><input type="text" name="id" cssClass="focus1"/></td> -->

 <td><form:select path="id" cssClass="focus1" onchange="this.form.submit()">
 <form:option value="0" label="--- Select ---"/>
<form:options items="${EmployeeList}"/>

</form:select>  
</td>
<td><form:errors path="id" cssClass="error"/></td>
</tr>
<tr>
</tr>


<tr>
<td><input type="submit"/></td>
</tr>

</table>
</div>
</form:form>

<c:if test="${!empty history}">
	<h3>Employees List</h3>

<div class="center">
<div class="pagination">
	<table class="tg" align="center" border="1">
	<tr class="employeetHeader">
		
		<th width="80">EmployeeId</th>
		<th width="120">StartDate</th>
		<th width="120">EndDate</th>
		<th width="120">Total Days</th>
		<th width="120">Leave Id</th>
		<th width="120">Leave Name</th>
		
		
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${history}" var="history">
	
		<tr class="employeeTR">
			<td  width="80">${history.empId}</td>
				<td width="120">${history.start_date}</td>
				<td width="120">${history.end_date}</td>
				<td width="120">${history.total_days}</td>
				<td width="120">${history.leaves.leaveId}</td>
				<td width="120">${history.leaves.leaveName}</td>
				
			<td width="60"><a href="<c:url value='/editEmployee/${history.empId}' />" >Edit</a></td>
			<td width="60"><a href="<c:url value='/removeEmployee/${history.empId}' />" >Delete</a></td>
		</tr>
	
	</c:forEach>
	</table>
	</div>
</c:if>
</body>
</html>