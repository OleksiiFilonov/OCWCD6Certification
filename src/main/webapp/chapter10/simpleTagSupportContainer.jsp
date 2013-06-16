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
    
    <% String [] books = new String [] {"Merphy", "JSP for idiots", "Profi", "One more book", "The life of Pie", "Watch it", "Check this out"};
       pageContext.setAttribute("books", books);
    %>
    
    <h1>Simple Tag support with an iteration over body several times</h1>
    <simple:iterateBody collection="${books}" elementName="iterationElement">
        ${param.test} print: <b>"${iterationElement}"</b>
    </simple:iterateBody>
    The last iterationElement tag="${iterationElement}" if you don't want to see it you have to remove it from scope<br/>
    <br/>
    
    <simple:tagdependentBody>
        It doesn't matter what parameters goest inside this body ${books} and ${param.test} 
    </simple:tagdependentBody>
    <br/>
    
    <h1>Dynamic attributes select tag</h1>
    <simple:select name="someName" size="1" test="test" IcanHaveWhateverIwant="nothing" nothingSpecial="nothingAtAll"  optionsList="${books}"/>
    <br/>
    
    <jsp:include page="throwExceptionPage.jsp"/>
    You will see this text
    
    <simple:skipPageException throwException="true">
        We will see this text inside body because it is invoked before exception<br/>
    </simple:skipPageException>
    You will never see that text while throwException="true"
</body>
</html>