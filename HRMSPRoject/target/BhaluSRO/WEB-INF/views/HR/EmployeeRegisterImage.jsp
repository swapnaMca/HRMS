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
<link href="${mainCss}" rel="stylesheet" />
<link href="${errCss}" rel="stylesheet" />

</head>
<body>
<div class="col-sm-8 text-left"> 
<c:url var="addAction" value="/Admin/saveEmployeeImage" ></c:url>
<form:form action="${addAction}" method="post" enctype="multipart/form-data" modelAttribute="employeeVOImage"  >
<div id="addEmployeeDiv">
<table align="center" >
<th align ="center" style="color:#0E4679">Employee Details</th>
<tr>
<!-- <td>Employee ID</td> --><td><form:hidden path="id" cssClass="focus1" /></td>
<td><form:errors path="id" cssClass="error"/></td></tr>
<tr>
<td>firstName</td><td><form:input path="firstName" cssClass="focus1"/></td>
<td><form:errors path="firstName" cssClass="error" /></td>
</tr>
<tr>
<td>LastName(*)</td><td><form:input path="lastName" cssClass="focus1"/></td>
<td><form:errors path="lastName" cssClass="error"/></td>
</tr>

<tr>
<td>Phone</td><td><form:input path="phone" cssClass="focus1"/></td>
<td><form:errors path="phone" cssClass="error"/></td>
</tr>
<tr>
<td>DOB</td><td><form:input path="dateOfBirth" cssClass="focus1"/></td>
<td><form:errors path="dateOfBirth" cssClass="error"/></td>
</tr>

<tr>
<td>hire_date</td><td><form:input path="hire_date" cssClass="focus1"/></td>
<td><form:errors path="hire_date" cssClass="error"/></td>
</tr>
<tr>
<td>JobId</td><td><form:input path="job_id" cssClass="focus1"/></td>
<td><form:errors path="job_id" cssClass="error"/></td>
</tr>
<tr>
<td>salary</td><td><form:input path="salary" cssClass="focus1"/></td>
<td><form:errors path="salary" cssClass="error"/></td>
</tr>



<tr>
<td>Department Id(*)</td><td><form:select path="department_id" cssClass="focus1">
 <form:option value="NONE" label="--- Select ---"/>
<form:options items="${DepartmentList}"/>

</form:select> </td>
<td><form:errors path="department_id" cssClass="error"/></td>
</tr>
<tr><td>Upload Image</td>
 <td><input type="file" name="image" id="image"/></td>
<%-- <td><form:input type="file" path="photo" id="photo" cssClass="focus1"/></td>  --%>


</tr>
<br><br>

<tr>
<td><input type="submit"/></td>

</tr>
<tr>
<td>
<a href="retrieveImage">ViewImage</a></td>
</tr>
</table>

</div>	
	</form:form>
	</div>
</body>
</html>