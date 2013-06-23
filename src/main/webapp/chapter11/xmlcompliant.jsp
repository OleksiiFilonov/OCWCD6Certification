<html xmlns:c="http://java.sun.com/jsp/jstl/core">
<jsp:directive.page import="java.util.List, java.util.ArrayList" />
<jsp:declaration>
    private int i = 5;
</jsp:declaration>
    <body>
        <jsp:scriptlet>
            List names = new ArrayList();
            names.add("Alexey");
            names.add("Valya");
            pageContext.setAttribute("namesList", names);
        </jsp:scriptlet>
        <jsp:expression>
            names
        </jsp:expression>
        <br/>
        <h1><jsp:text>For each</jsp:text></h1>
        <c:forEach var="test" items="${namesList}">
            ${test} - 1
        </c:forEach>
    </body>
</html>