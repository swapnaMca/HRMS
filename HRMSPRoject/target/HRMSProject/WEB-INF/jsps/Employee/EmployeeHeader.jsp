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
   <li><a href="#">Home</a></li>
       
        <li><a href="#">Projects</a></li>
        <li><div class="dropdown">
				<button class="dropbtn">
					Profile <i class="fa fa-caret-down"></i>
				</button>
				<div class="dropdown-content">
					<spring:url value="/viewProfile/${login.id}/${login.employeeLogin.role}" var="viewProfile" htmlEscape="true" />
<a href="${viewProfile}" >View Profile</a>
   <spring:url value="/LoadChangePassword/${login.employeeLogin.role}" var="changePassword" htmlEscape="true" />
 <a href="${changePassword}" >EditProfile
  <spring:url value="/images" var="images" />
    <img src="${images}/editIcon.png" width="30" height="23" /> 
    </a>
				</div>
			</div>
			</li>
        <li>
			<div class="dropdown">
				<button class="dropbtn">
					Leaves <i class="fa fa-caret-down"></i>
				</button>
				<div class="dropdown-content">
					 <spring:url value="/LeaveRequest" var="leaveRequest" htmlEscape="true" />
	<a href="${leaveRequest}" >Apply Leave</a>
					<spring:url value="/checkEmployeeLeaveStatus/${login.id}" var="checkEmployeeLeaveStatus" htmlEscape="true" />
	<a href="${checkEmployeeLeaveStatus}" >Visit LeaveStatus</a>
				</div>
			</div>
		</li>
        </ul>
      <ul class="nav navbar-nav navbar-right">
     
<!--   <li><a href="LogOut"><span class="glyphicon glyphicon-log-in"></span> LogOut</a></li>
 --> 
 
 <c:if test="${!empty userImage}">
 <c:url var="changeProfilePic" value="/changeProfilePic"></c:url>
 
  <li><form:form id="ProfilePicChangeForm" action="${changeProfilePic}/user" modelAttribute="employeeLogin"><img id="ProfilePic" width="100" height="100" src="data:image/jpeg;base64,${userImage}"  style="border:1px solid cyan ;cursor: pointer;" onclick="changeProfilePic()" class="img-circle"/>
 </form:form></li>
 
 
 </c:if>
 <%-- <li><img width="100" height="100" src="data:image/jpeg;base64,${userImage}"/></li> --%>
 <li><spring:url value="/LogOut" var="LogOut" htmlEscape="true" />
<a href="${LogOut}">LogOut</a></li>
   </ul>
</body>
</html>