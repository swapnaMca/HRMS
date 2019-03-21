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
<spring:url value="/resources/main.css" var="mainCss" />
<spring:url value="/resources/error.css" var="errCss" />
<script src="<c:url value="/js/main.js" />"></script>
<link href="${mainCss}" rel="stylesheet" />
<link href="${errCss}" rel="stylesheet" />

</head>
<body>

<div class="col-sm-8 text-left"> 
<c:url var="addAction" value="/Admin/saveProject" ></c:url>
<form:form action="${addAction}"  modelAttribute="employeeProjects">
<div id="addProjects">
<table align="center" >
<th align ="center" style="color:#0E4679">Add Projects</th>
<tr>
<!-- <td>Employee ID</td> --><td><form:hidden path="Id" cssClass="focus1" /></td>
<td><form:errors path="Id" cssClass="error"/></td></tr>
<tr>
<tr>
<tr>
<td>Employee ID</td>
<td>
<form:select path="empId" cssClass="focus1">
 <form:option value="0" label="--- Select ---"/>
<form:options items="${EmployeeList}"/>

</form:select> </td>
<td><form:errors path="empId" cssClass="error"/></td></tr>
<tr>

<td>Project Id</td>
<td><form:select path="projects.projectId" cssClass="focus1" onchange="load(this.value)">
 <form:option value="0" label="--- Select ---"/>
<form:options items="${projectIdList}"/>

</form:select></td>
<td><form:errors path="projects.projectId" cssClass="error" /></td>
</tr>
<%-- <tr>

<td>ProjectName(Handled)</td>
<td><form:select path="projectHandled" cssClass="focus1">
 <form:option value="NONE" label="--- Select ---"/>
<form:options items="${projectHandled}"/>

</form:select></td>
<td><form:errors path="projectHandled" cssClass="error" /></td>
</tr> --%>
<tr><td>ProjectName(Handled)</td>
<td><form:input path="projectHandled" id="projectHandled" cssClass="error"/></td>
<td><form:errors path="projectHandled" cssClass="error" /></td>
</tr>
<tr>
<td>StartDate</td><td><form:input type="date"  path="dateStarted" cssClass="focus1"/></td>
<td><form:errors path="dateStarted" cssClass="error" /></td>
</tr>
<tr>
<td>EndDate</td><td><form:input type="date"  path="dateEnded" cssClass="focus1"/></td>
<td><form:errors path="dateEnded" cssClass="error" /></td>
</tr>
<tr>
<td>Status</td><td><form:input path="status"  cssClass="focus1"/></td>
<td><form:errors path="status" cssClass="error" /></td>
</tr>

<tr>
<td><input type="submit"/></td>

</tr>
</table>

</div>	
	</form:form>
	</div>
</body>
</html>