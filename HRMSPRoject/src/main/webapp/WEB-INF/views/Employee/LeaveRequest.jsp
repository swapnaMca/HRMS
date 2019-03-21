<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>${LeaveList}
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<spring:url value="/resources/style.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />

</head>
<body>

<div class="col-sm-8 text-left"> 
<c:url var="sendLeaveRequest" value="sendLeaveRequest" ></c:url>
<form:form action="${sendLeaveRequest}" modelAttribute="employeeLeave">
<table align="center" >
<tr>
<tr>
<td><form:hidden path="empId" value="${login.id}" cssClass="focus1"/></td>
<td><form:errors path="empId" cssClass="error" /></td>
</tr>
<td>Leave ID</td><td><form:select path="leaves.leaveId" cssClass="focus1">
 <form:option value="0" label="--- Select ---"/>
 <c:forEach items="${LeavesList}" var="leaves">
                   <form:option value="${leaves.leaveId}">${leaves.leaveId}
                   </form:option>
                </c:forEach>
</form:select> </td>
<td><form:errors path="leaves.leaveId" cssClass="error"/></td></tr>

<tr>
<td>Start Date(*)</td><td><form:input type="date" path="start_date" cssClass="focus1"/></td>
<td><form:errors path="start_date" cssClass="error"/></td>
</tr>
<tr>
<td>End Date(*)</td><td><form:input type="date" path="end_date" cssClass="focus1"/></td>
<td><form:errors path="end_date" cssClass="error"/></td>
</tr>

<tr>
<td>No.of Days</td><td><form:input path="total_days" cssClass="focus1"/></td>
<td><form:errors path="total_days" cssClass="error"/></td>
</tr>


<tr>
<td><input type="submit"/></td>

</tr>

</table>
${Success}
</form:form>

</div>
</body>
</html>