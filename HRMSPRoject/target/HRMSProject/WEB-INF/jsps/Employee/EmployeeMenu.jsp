<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
 
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <!-- for PopUp menu -->
 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<spring:url value="/resources/BootStrap.css" var="bootStrap" />
<link href="${bootStrap}" rel="stylesheet" />
</head>
<body>

<div class="btn-group-vertical">
<spring:url value="/viewProfile/${login.id}/${login.employeeLogin.role}" var="viewProfile" htmlEscape="true" />
<a href="${viewProfile}" class="btn btn-primary">View Profile</a>
   <spring:url value="/LoadChangePassword/${login.employeeLogin.role}" var="changePassword" htmlEscape="true" />
 <a href="${changePassword}" class="btn btn-primary">EditProfile
  <spring:url value="/images" var="images" />
    <img src="${images}/editIcon.png" width="30" height="23" /> 
</a>
<!-- For Leaves Menu Popup -->
<a href=".collapse" class="btn btn-primary" data-toggle="collapse">Leaves>></a>
  <div  id="collapseDive" class="collapse">
  <spring:url value="/LeaveRequest" var="leaveRequest" htmlEscape="true" />
	<a href="${leaveRequest}" class="collapseLink">Apply Leave</a>
	
  </div>
   <div  id="collapseDive" class="collapse">
  <spring:url value="/checkEmployeeLeaveStatus/${login.id}" var="checkEmployeeLeaveStatus" htmlEscape="true" />
	<a href="${checkEmployeeLeaveStatus}" class="collapseLink">Visit LeaveStatus</a>
	
  </div>
  </div>
  
</body>
</html>