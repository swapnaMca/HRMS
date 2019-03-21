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

</head>
<body>
 <ul class="nav navbar-nav">
  <li>
         <spring:url value="/Admin/HRHome" var="HRHome" htmlEscape="true" />
         <a href="${HRHome}">Home</a>
         </li>
         <li class="active">
         <spring:url value="Setup" var="Setup" htmlEscape="true" />
         <a href="Setup/${Setup}">Setup</a>
         </li>
        <li>
        <spring:url value="/Admin/Projects" var="Projects" htmlEscape="true" />
        <a href="${Projects}">Projects</a>
        </li>
      
        </ul>
      <ul class="nav navbar-nav navbar-right">

 <li><spring:url value="/LogOut" var="LogOut" htmlEscape="true" />
<a href="${LogOut}">LogOut</a></li>
   </ul>
</body>
</html>