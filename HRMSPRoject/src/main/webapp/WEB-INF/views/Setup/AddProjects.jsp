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
<c:url var="addAction" value="/Setup/addProjects" ></c:url>
<form:form action="${addAction}"  modelAttribute="projects">
<div id="addProjects">
<table align="center" >
<th align ="center" style="color:#0E4679">Add Projects</th>
<tr>
<td>Project ID</td><td><form:hidden path="projectId" cssClass="focus1" /></td>
<td><form:errors path="projectId" cssClass="error"/></td></tr>
<tr>
<tr>
<td>Project Name</td><td><form:input path="projectName" cssClass="focus1" /></td>
<td><form:errors path="projectName" cssClass="error"/></td>
</tr>
<tr>
<td>Project Status</td><td><form:input path="projectStatus" cssClass="focus1" /></td>
<td><form:errors path="projectStatus" cssClass="error"/></td>
</tr>
<tr>
<td><input type="submit"/></td>

</tr>
<tr>

</tr>
</table>

</div>	
	</form:form>
	</div>
	<c:if test="${!empty suceess}">
${suceess}
</c:if>
</body>
</html>