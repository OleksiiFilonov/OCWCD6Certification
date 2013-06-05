<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
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