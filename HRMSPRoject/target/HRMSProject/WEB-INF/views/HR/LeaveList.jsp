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


<form:form action="${pageContext.request.contextPath}/Admin/searchLeaveHistoryByDate"  modelAttribute="employeeLeave">
<div id="addEmployeeDiv">
<table align="center" >
<tr>
<td>From Date*</td>
 <td><form:input type="date" path="start_date" cssClass="focus1"></form:input>  
</td>
<td><form:errors path="start_date" cssClass="error"/></td>
</tr>

<tr>
<td>End Date *</td>
 <td><form:input type="date" path="end_date" cssClass="focus1"></form:input>  
</td>
<td><form:errors path="end_date" cssClass="error"/></td>
</tr>
<tr>
<td>Select status</td>
 <td><form:select path="leave_status" cssClass="focus1" >
 <form:option value="All" label="All"/>
 <form:option value="Pending" label="Pending"/>
 <form:option value="Accept" label="Accept"/>
<form:option value="Reject" label="Reject"/>

</form:select>
</td>
<td><form:errors path="leave_status" cssClass="error"/></td>
</tr>
<tr>
<td><input type="submit" value="Search"/></td>
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
		<th width="80">Id</th>
		<th width="80">EmployeeId</th>
		<th width="120">StartDate</th>
		<th width="120">EndDate</th>
		<th width="120">Total Days</th>
		<th width="120">Leave Id</th>
		<th width="120">Leave Name</th>
		<th width="60">Status</th>
			<th width="60"></th>
		
	</tr>
	<c:forEach items="${history}" var="history">
	
		<tr class="employeeTR">
		<td  width="80">${history.getId()}</td>
			<td  width="80">${history.empId}</td>
				<td width="120">${history.start_date}</td>
				<td width="120">${history.end_date}</td>
				<td width="120">${history.total_days}</td>
				<td width="120">${history.leaves.leaveId}</td>
				<td width="120">${history.leaves.leaveName}</td>
				<td>
				<c:if test="${history.leave_status eq 'Pending'}">
				
				
				<form:form action="${pageContext.request.contextPath}/Admin/leaveHistoryStatus/${history.getId()}/ByDate"  modelAttribute="employeeLeave">
				<form:select path="leave_status" cssClass="focus1" >
				
 <form:option value="Pending" label="Pending"/>
 <form:option value="Accept" label="Accept"/>
<form:option value="Reject" label="Reject"/>

</form:select>

<td><input type="submit" value="Send"/></td>
</form:form>
</c:if>
 <c:if test="${history.leave_status ne 'Pending'}">
${history.leave_status}
</c:if> 
</td>
				
					
			
		</tr>
	
	</c:forEach>
	</table>
	
	
	</div>
</c:if>
<%-- <c:if test="${! empty  history.leave_status}">
<h1>${history.leave_status}</h1>
</c:if> --%>
</body>
</html>