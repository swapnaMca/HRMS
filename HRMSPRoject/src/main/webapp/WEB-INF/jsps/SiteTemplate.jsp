<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>
<tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute>
</title>
</head>
<body>

<table border="1" cellpadding="2" cellspacing="2" align="left" width="100%" height="100%">
<tr>

<td colspan="2" align="center">
<tiles:insertAttribute name="header"></tiles:insertAttribute>
</td>
</tr>
<tr>
<td>
<tiles:insertAttribute name="menu"></tiles:insertAttribute>
</td>
<td colspan="2" align="right">
<tiles:insertAttribute name="body"></tiles:insertAttribute>
</td>
</tr>
<tr>
<td colspan="2″  align="center">
<tiles:insertAttribute name="footer"></tiles:insertAttribute>
</td>
</tr>
</table>
</div>
</body>
</html>