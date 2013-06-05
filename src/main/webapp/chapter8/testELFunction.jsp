<%@ page import="java.util.List, java.util.ArrayList"%>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="CustomELFunctionLib" prefix="test" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test Addition and Multiplication EL functions</title>
</head>
<body>
	<%
		List operands = new ArrayList<Integer>();
		operands.add(2);
		operands.add(3);
		pageContext.setAttribute("operands", operands);
	%>
	
	Addition:  ${test:add(2,3)} <br/>
	Multiplication: ${test:multy(operands)}<br/>
</body>
</html>