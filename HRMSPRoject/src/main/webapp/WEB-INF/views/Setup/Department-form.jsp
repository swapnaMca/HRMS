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
<spring:url value="/resources/tableDecor.css" var="tableCss" />
<link href="${mainCss}" rel="stylesheet" />
<link href="${errCss}" rel="stylesheet" />
<link href="${tableCss}" rel="stylesheet" />
</head>
<body>
<form:form action="${pageContext.request.contextPath}/Setup/addDepartments" modelAttribute="departmentVO">
<div id="addEmployeeDiv">
<table align="center" >
<tr>
<td>Department ID</td><td><form:input path="DepartmentId" cssClass="focus1"/></td>
<td><form:errors path="DepartmentId" cssClass="error"/></td></tr>
<tr>
<td>Department Name</td><td><form:input path="DepartmentName" cssClass="focus1"/></td>
<td><form:errors path="DepartmentName" cssClass="error" /></td>
</tr>
<tr>
<td> Location(*)</td><td><form:input path="DepartmentLoc" cssClass="focus1"/></td>
<td><form:errors path="DepartmentLoc" cssClass="error"/></td>
</tr>
<tr>
>
<tr>
 <%-- <c:forEach var="dept" items="${DepartmentList}" >
 <td  width="80">${dept.DepartmentName}</td>
 </c:forEach> --%>
 
</tr>
<tr>
<td><input type="submit"/></td>

</tr>

</table>

</div>	
	</form:form>
	<h3>Existing List</h3>
<c:if test="${!empty DepartmentList}">
<div class="center">
<div class="pagination">
	<table class="tg">
	<tr class="departmentHeader">
		
		<th width="80">ID</th>
		<th width="120">Name</th>
		<th width="120">Loc</th>
		
		
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	
	
<c:forEach items="${DepartmentList}" var="department">
	
		<tr class="alternative_cls">
		<td  width="80">${department.getDepartmentId()}</td>
				<td width="120">${department.getDepartmentName()}</td>
				<td width="120">${department.getDepartmentLoc()}</td> 
				
			<td width="60"><a href="<c:url value='/editEmployee/${department.getDepartmentId()}' />" onMouseOver="this.style.color='#0F0'" onMouseOut="this.style.color='#00F'" >Edit</a></td>
			<td width="60"><a href="<c:url value='/removeEmployee/${department.getDepartmentId()}' />" onMouseOver="this.style.color='#0F0'" onMouseOut="this.style.color='#00F'"  >Delete</a></td>
		</tr>
	

    	</c:forEach>
    
	</table>
	</div>
</c:if>
</body>
</html>