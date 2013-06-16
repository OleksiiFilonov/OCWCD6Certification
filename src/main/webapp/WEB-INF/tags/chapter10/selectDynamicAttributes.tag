<%@ tag import="java.util.Date" body-content="empty" dynamic-attributes="dynamicAttributes" %>

<%@ attribute name="name" required="true" %>
<%@ attribute name="size" required="true" %>
<%@ attribute name="options" required="true" rtexprvalue="true" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
Current Date: <%= new Date() %><br/>

<select name="name" size="size"
    <c:forEach var="attribute" items="${dynamicAttributes}">
        ${attribute.key}="${attribute.value}"
    </c:forEach>
>
    <c:forEach var="item" items="${options}">
        <option value="${item}">${item}</option>
    </c:forEach>
</select>