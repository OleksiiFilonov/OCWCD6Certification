<%@ taglib prefix="simple" uri="simpleTagSupportBodies" %>
<%@ page import="java.util.Date" %>
<html>
<body>
    <h1>Simple Tag support without body but with one required non expression attribute</h1>
    <simple:emptyBody testAttribute="Passed attribute as string"/><br/>
    <h1>Simple Tag support with a Scriptless body without attributes</h1>
    <simple:jspBody>
        Print parameter test = "${param.test}" <br/>
    </simple:jspBody>
    <% String [] books = new String [] {"Merphy", "JSP for idiots", "Profi", "One more book"};
       pageContext.setAttribute("books", books);
    %>
    <h1>Simple Tag support with an iteration over body several times</h1>
    <simple:iterateBody collection="${books}" elementName="iterationElement">
        ${param.test} print: <b>"${iterationElement}"</b>
    </simple:iterateBody>
    <simple:tagdependentBody>
        It doesn't matter what parameters goest inside this body ${books} and ${param.test} 
    </simple:tagdependentBody>
</body>
</html>