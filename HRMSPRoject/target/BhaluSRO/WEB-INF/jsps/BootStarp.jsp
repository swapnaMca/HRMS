<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<spring:url value="/resources/BootStrap.css" var="bootStrap" />
<link href="${bootStrap}" rel="stylesheet" />
<title>
<tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute>
</title>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    
    <div class="collapse navbar-collapse" id="myNavbar">
             <tiles:insertAttribute name="header"></tiles:insertAttribute>
     
    </div>
  </div>
</nav>
  


<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
     <tiles:insertAttribute name="menu"></tiles:insertAttribute>
    </div>
    <div class="col-sm-10 text-left"> 
     <tiles:insertAttribute name="body"></tiles:insertAttribute>
      
    </div>
  
  </div>
</div>
<%-- <footer class="container-fluid text-center">
  <tiles:insertAttribute name="footer"></tiles:insertAttribute>
</footer> --%>

</body>
</html>