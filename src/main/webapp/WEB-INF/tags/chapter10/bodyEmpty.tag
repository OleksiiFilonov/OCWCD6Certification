<%@ tag body-content="empty" %>
<%@ attribute name="requiredAttrib" required="true" rtexprvalue="true" %>
<%@ attribute name="notRequiredAttrib" rtexprvalue="false"%>
Body empty tag required value: <b>"${requiredAttrib}"</b> and not required value <b>"${notRequiredAttrib}"</b>
<br/>
