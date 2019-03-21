<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<nav class="nav">
  <ul id="menu">
  <li>
    <spring:url value="/employee" var="homeUrl" htmlEscape="true" />
<a href="${homeUrl}">Add Employee</a>
</li>
 <li>
 <spring:url value="/getAllEmployees" var="getAllEmployees" htmlEscape="true" />
<a href="${getAllEmployees}">View Employees</a>
 
 </li>
<li>
    <spring:url value="/employee1M" var="personListUrl" htmlEscape="true" />
<a href="${personListUrl}">Employee-Department</a>
</li>
 <li>
    <spring:url value="/LoadEmployee1To1Bidirectional" var="Load" htmlEscape="true" />
<a href="${Load}">EmployeeRoleBidirectional</a>
</li>
<li>
 <spring:url value="/createDepartment" var="Load" htmlEscape="true" />
<a href="${Load}">createDepartmentUsingAnnotaions</a>

</li>
</ul> 
</nav>