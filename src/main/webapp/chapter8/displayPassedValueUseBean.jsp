<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Use Bean JSP page</title>
</head>
<body>
	<div id="container">
		<jsp:useBean id="employee" type="com.example.chapter8.Person" class="com.example.chapter8.Employee" scope="request">
			<h1>If bean doesn't created before set passed values</h1>
			<jsp:setProperty name="employee" property="*"/>
			<jsp:setProperty name="employee" property="firstName" param="first"/>
		</jsp:useBean>
		<div style="clear:both;">First Name : <jsp:getProperty property="firstName" name="employee"/> </div>
		<div style="clear:both;">Last Name: <jsp:getProperty property="lastName" name="employee"/></div>
		<div style="clear:both;">Id: <jsp:getProperty name="employee" property="id"/></div>
	</div>
</body>
</html>