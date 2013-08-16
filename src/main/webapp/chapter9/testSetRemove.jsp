<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Map, java.util.HashMap"%>

<jsp:useBean id="employee" class="com.example.chapter8.Employee" scope="request">
    <jsp:setProperty name="employee" property="firstName" value="Oleksii"/>
    <jsp:setProperty name="employee" property="lastName"  value="Filonov"/>
    <jsp:setProperty name="employee" property="id" value="1"/>
</jsp:useBean>

<% Map<String, String> testMap = new HashMap<String, String>();
   
   request.setAttribute("testMap", testMap);
%>

    Test weather values of bean set correctly<br>
    First Name was: <c:out value="${employee.firstName}"/><br>
    Replace first name with <b>Oleg</b> value <br>
    <c:set target="${employee}" property="firstName">Oleg</c:set>
    First Name now: <c:out value="${employee.firstName}"/><br>
    Last Name was: <c:out value="${employee.lastName}"/><br>
    Replace last name with <b>Filimonov</b> value <br>
    <c:set target="${employee}" property="lastName">Filimonov</c:set>
    Last Name now: <c:out value="${employee.lastName}"/><br>
    
    <c:if test="${empty testMap}">
        Map should be empty so let's add a key:value - pair<br>
        <c:set target="${testMap}" property="key" value="value"/>
        <c:set target="${testMap}" property="key1" value="value1"/>
    </c:if>
    <br/>
    testMap.get("key") = '${testMap.get("key")}' <br/>
    testMap["key"] = '${testMap["key"]}'<br/>
    Now map contains ${testMap.size()} elements <br/>
    Let's itterate over them<br>
    <c:forEach var="entry" items="${testMap}">
        ${entry.key}:${entry.value}<br>
    </c:forEach>
    
    just set the regular variable:
    <c:set var="variable" value="someValue" scope="page"/>
    "${variable}" <br/>
    and remove it now with null value
    <c:set var="variable" value=""/>
    "${variable}" <br/>
    
    Let's remove testMap now
    <c:remove var="testMap"/>
    and try to access once again in catch block<br/>
    It should return nothing "${testMap}" <br/>
    <c:catch var="caughtException" >
        <c:set target="${testMap}" property="testKey"  value="testValue"/>
        If you see this something went wrong and you are not on the Earth anymore :-)
    </c:catch>
    I caught an exception "${caughtException}"<br/> 
    
    
    
    
    
    
    
    