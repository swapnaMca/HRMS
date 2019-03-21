<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Welcome to HRMS</title>
</head>
<body>
	<table border="1" cellpadding="2" cellspacing="2" align="center"
		width="100%">
		<tr>
			<td height="10" colspan="2">

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>

<spring:url value="/resources/Alignments.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />
<spring:url value="/resources/styles.css" var="styleCss" />
<link href="${styleCss}" rel="stylesheet" />
<spring:url value="/resources/body_bg.jpg" var="imageUrl" />
<style type="text/css">

body {
	
}
</style>

</head>
<body>


	<div id="wrapper">

		<div id="top" class="clear">
			<h1>
				<a href="#">HRMS</a>
			</h1>

			<ul>
				<li class="selected"><a href="engg-form">Item</a></li>
				<li><a href="Sales-form">Sales Order</a></li>
				<li><a href="customer-form">Customer</a></li>
				<li><a href="purchase-form">Purchase Order</a></li>
				<li><a href="hrManager-form">HR</a></li>
				<li><a href="account-form">Accounts</a></li>
				<li><a href="wareHouse-form">WareHouse</a></li>
				<li><a href="invoice-form">Invoice</a></li>
				<li><a href="production-form">Production</a></li>
				<li><a href="manufacture-form">Mfg</a></li>
				<li><a href="setup">Setup</a></li>
			</ul>
		</div>

	</div>
</body>
</html>


			</td>
		</tr>
		<tr>
			<td style="width: 5%; height: 450px;">WebContent/resources/modulesMenu.jsp</td>
			<td width="450"></td>
		</tr>
		<tr>
			<td height="30" colspan="2">

<head>
<spring:url value="/resources/styles.css" var="styleCss" />
<link href="${styleCss}" rel="stylesheet" />
</head>
<div class="footer">
	Copyright &copy; SPPS Ltd.
</div>


			</td>
		</tr>
	</table>
	
</body>
</html>