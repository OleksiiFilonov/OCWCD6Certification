<%@ taglib uri="classicalTags" prefix="classic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ page import="java.util.List,java.util.ArrayList" %>
<html>
<body>
    <h1>Test Classical TagSupport</h1>
    <c:set var="td_element" value="Abracadabra!"/>
    <% List<String> options = new ArrayList<String>();
    options.add("one"); options.add("two"); options.add("three");
    pageContext.setAttribute("optionsList", options);
    %>
    <classic:table options="${optionsList}" element="td_element" border="1">
        <tr>${td_element}</tr>
    </classic:table>
    td_element after = <b>"${td_element}"</b>
</body>
</html>