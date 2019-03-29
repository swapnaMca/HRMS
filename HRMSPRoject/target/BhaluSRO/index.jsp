<!DOCTYPE html>
<html lang="en">
<head>
  <title>HRMS</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 550px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #c2a4d2;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
    .text-left
    {
    /* background-color: #c8c3da*/ ;
 	  height: 550px;
    }
    .navbar-inverse{
    background-color: #225486;
    }
    
  </style>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <spring:url value="/images/Logo.jpg" var="logo" />
         <img width=100 height=80 src="${logo}"/>
      <%-- <a class="navbar-brand" href="${image1}">Logo</a> --%>
    </div>
     <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><a href="#">Home</a></li>
        <li><a href="#">About</a></li>
        <li><a href="#">Projects</a></li>
        <li><a href="#">Contact</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
      
        <li><a href="Login" ><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
    </div>
  </div>
</nav>
  
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
     
    </div>
    <div class="col-sm-8 text-left"> 
      <h1>WelCome To HRMS</h1>
      <marquee>
       <spring:url value="/images/MarqueeImage.jpg" var="MarqueImage" />
         <img src="${MarqueImage}"/>
          <spring:url value="/images/employeeMarquee.jpg" var="MarqueImage" />
         <img src="${MarqueImage}"/>
          <spring:url value="/images/employee2.jpg" var="MarqueImage" />
         <img src="${MarqueImage}"/>
      </marquee>
      <p>
     
A Human Resources Management System (HRMS) is a type of information system (IS) that is designed to manage an organization's computerized and automated human resource (HR) processes. It is a combination of hardware and software resources that hosts and provides most, if not all, of a HR department's business logic K

      </p>
    </div>
    <div class="col-sm-2 sidenav">
      <spring:url value="/images/hrms.jpg" var="image1" />
         <img width=220 height=172 src="${image1}"/>
     </br> 
     
      <spring:url value="/images/image1.jpg" var="image1" />
         <img width=220 height=172 src="${image1}"/>
     </br>
     
      <spring:url value="/images/image2.jpg" var="image1" />
         <img width=220 height=172 src="${image1}"/>
   
    </div>
  </div>
</div>

<footer class="container-fluid text-center">
  <p>Footer Text</p>
</footer>

</body>
</html>
