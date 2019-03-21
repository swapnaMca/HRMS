<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<spring:url value="/resources/BootStrap.css" var="bootStrap" />
<link href="${bootStrap}" rel="stylesheet" />
</head>
<body>
<div class="btn-group-vertical">
<spring:url value="/Admin/RegisterEmployee" var="RegisterEmployee" htmlEscape="true" />
<a href="${RegisterEmployee}" class="btn btn-primary">Add Employee</a>
<spring:url value="/Admin/viewAllEmployees" var="viewAllEmployees" htmlEscape="true" />
<a href="${viewAllEmployees}" class="btn btn-primary">AllEmployees</a>

<spring:url value="/Admin/leaveHistoryRequest" var="leaveHistory" htmlEscape="true" />
<a href="${leaveHistory}" class="btn btn-primary">Leave History</a>
   <spring:url value="/Admin/RegisterImageEmployee" var="RegisterEmployee" htmlEscape="true" />
<a href="${RegisterEmployee}" class="btn btn-primary">Add EmployeeRegister</a>
  </div>
</body>
</html>