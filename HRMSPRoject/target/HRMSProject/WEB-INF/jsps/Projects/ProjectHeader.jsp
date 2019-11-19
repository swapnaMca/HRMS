<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<spring:url value="/resources/BootStrap.css" var="bootStrap" />
<link href="${bootStrap}" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/js/main.js"></script>
</head>
<body>
	<ul class="nav navbar-nav">

		<li>
			<div class="dropdown">
				<button class="dropbtn">
					Home <i class="fa fa-caret-down"></i>
				</button>
				<div class="dropdown-content">
					<spring:url value="/Admin/HRHome" var="HRHome" htmlEscape="true" />
					<a href="${HRHome}">Home</a>
				</div>
			</div>
		</li>
		<li>
			<div class="dropdown">
				<button class="dropbtn">
					Setup <i class="fa fa-caret-down"></i>
				</button>
				<div class="dropdown-content">
					<spring:url value="/Setup/AddProjectRequest" var="AddProject"
						htmlEscape="true" />
					<a href="${AddProject}">Add Projects</a>
					<spring:url value="/Setup/departments" var="departments"
						htmlEscape="true" />
					<a href="${departments}">Department</a>
				</div>
			</div>
		</li>

		<li>
			<div class="dropdown">
				<button class="dropbtn">
					Employee <i class="fa fa-caret-down"></i>
				</button>
				<div class="dropdown-content">
					<spring:url value="/Admin/RegisterEmployee" var="RegisterEmployee"
						htmlEscape="true" />
					<a href="${RegisterEmployee}">Add Employee</a>
					<spring:url value="/Admin/viewAllEmployees" var="viewAllEmployees"
						htmlEscape="true" />
					<a href="${viewAllEmployees}">AllEmployees</a>
				</div>
			</div>
		</li>
		<li>
			<div class="dropdown" class="active">
				<button class="dropbtn">
					Projects <i class="fa fa-caret-down"></i>
				</button>
				<div class="dropdown-content">
					
<spring:url value="/Admin/AssignProjectRequest" var="AssignProject" htmlEscape="true" />
<a href="${AssignProject}">Assign Project</a>
				</div>
			</div>
		</li>
		<li>
			<div class="dropdown">
				<button class="dropbtn">
					Leaves <i class="fa fa-caret-down"></i>
				</button>
				<div class="dropdown-content">
					<spring:url value="/Admin/leaveHistoryRequest" var="leaveHistory"
						htmlEscape="true" />
					<a href="${leaveHistory}">EmployeeLeave History</a>
					<spring:url value="/Admin/leaveHistoryRequest" var="leaveHistory"
						htmlEscape="true" />
					<a href="${leaveHistory}">Leave List</a>
				</div>
			</div>
		</li>
	</ul>
	<ul class="nav navbar-nav navbar-right">
		<%-- <c:if test="${!empty userImage}">
 <li><img width="100" height="100" src="data:image/jpeg;base64,${userImage}" /></li>
 </c:if>  --%>
		<c:if test="${!empty userImage}">
			<c:url var="changeProfilePic" value="/changeProfilePic"></c:url>

			<li><form:form id="ProfilePicChangeForm"
					action="${changeProfilePic}/Admin" modelAttribute="employeeLogin">
					<img id="ProfilePic" width="80" height="80"
						src="data:image/jpeg;base64,${userImage}"
						style="border: 1px solid cyan; cursor: pointer;"
						onclick="changeProfilePic()" class="img-circle" />
				</form:form></li>


		</c:if>

		<li><spring:url value="/LogOut" var="LogOut" htmlEscape="true" />
			<a href="${LogOut}">LogOut</a></li>
	</ul>
</body>
</html>