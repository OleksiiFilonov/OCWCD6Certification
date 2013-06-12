<%@ taglib prefix="chapter10" tagdir="/WEB-INF/tags/chapter10" %>
<%@ taglib prefix="tagdependent" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="default" uri="defaultScriptlessTagURI" %>
<html>
<body>
    <h1>Tag Container JSP</h1>
    <h2>Include empty body tag</h2>
    <chapter10:bodyEmpty requiredAttrib="${param.tagParam}" notRequiredAttrib="Must be string"/>   
    <h2>Include empty body tag without notRequeiredAttrib</h2>
    <chapter10:bodyEmpty requiredAttrib="Without required attribute"/>
    <h2>Evaluate body as tagdependent</h2>
    <tagdependent:tagdependentBody>
        It doesn't matter what ${param.tagParam} goes inside this tag body
    </tagdependent:tagdependentBody>
    <h2>Evaluate body as default scriptless</h2>
    <default:defaultBody>
        It matters what ${param.tagParam} goes inside this tag body
    </default:defaultBody>
</body>
</html>