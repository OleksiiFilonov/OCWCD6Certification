<%@page import="com.example.chapter8.Employee"%>
<% 
Employee noSuchObject = (Employee) request.getAttribute("noSuchObject");
noSuchObject.getFirstName();//NPE :-)
%>