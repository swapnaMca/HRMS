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
<spring:url value="/resources/style.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />
<spring:url value="/resources/tableDecor.css" var="tableCss" />
<link href="${tableCss}" rel="stylesheet" />
</head>
<body>
<c:if test="${!empty LeaveStatus}">
	<h3>Leaves History</h3>

<div class="center">
<div class="pagination">
	<table class="tg" align="center" border="1">
	<tr class="employeetHeader">
		<th width="80">Id</th>
		<th width="80">EmployeeId</th>
		<th width="120">StartDate</th>
		<th width="120">EndDate</th>
		<th width="120">Total Days</th>
		<th width="120">Leave Id</th>
		<th width="120">Leave Name</th>
		<th width="60">Status</th>
			
		
	</tr>
	<c:forEach items="${LeaveStatus}" var="LeaveStatus">
	
		<tr class="employeeTR">
		<td  width="80">${LeaveStatus.getId()}</td>
			<td  width="80">${LeaveStatus.empId}</td>
				<td width="120">${LeaveStatus.start_date}</td>
				<td width="120">${history.end_date}</td>
				<td width="120">${LeaveStatus.total_days}</td>
				<td width="120">${LeaveStatus.leaves.leaveId}</td>
				<td width="120">${LeaveStatus.leaves.leaveName}</td>
				<td width="120">${LeaveStatus.leave_status}</td>
</tr>
	
	</c:forEach>
	</table>
	
	</div>
	</div>
</c:if>
<c:if test="${empty LeaveStatus}">
<h1>No Leaves History </h1>
</c:if>
</body>
</html>