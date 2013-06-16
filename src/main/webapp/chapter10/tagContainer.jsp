<%@ taglib prefix="chapter10" tagdir="/WEB-INF/tags/chapter10" %>
<%@ taglib prefix="tagdependent" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="default" uri="defaultScriptlessTagURI" %>
<%@ page import="java.util.List,java.util.Arrays" %>
<html>
<body>
    <h1>Tag Container JSP</h1>
    <h2>Include empty body tag</h2>
    <chapter10:bodyEmpty requiredAttrib="${param.tagParam}" notRequiredAttrib="Must be string"/>
    <br/>   
    
    <h2>Include empty body tag without notRequeiredAttrib</h2>
    <chapter10:bodyEmpty requiredAttrib="Without required attribute"/>
    <br/>
    
    <h2>Evaluate body as tagdependent</h2>
    <tagdependent:tagdependentBody>
        It doesn't matter what ${param.tagParam} goes inside this tag body
    </tagdependent:tagdependentBody>
    <br/>
    
    <h2>Evaluate body as default scriptless</h2>
    <default:defaultBody>
        It matters what ${param.tagParam} goes inside this tag body
    </default:defaultBody>
    <br/>
    
    <% List<String> books = Arrays.asList("Merphy", "JSP for idiots", "Profi", "One more book", "The life of Pie", "Watch it", "Check this out");
       pageContext.setAttribute("books", books);
    
    %>    
    <h2>Iteration Tag With dynamic Attributes</h2>
    <chapter10:selectDynamicAttributes options="${books}" name="testName" size="1" someAttribute="someAttribute" oneMoreAttribute="testAttribute"/>
    <br/>    
</body>
</html>