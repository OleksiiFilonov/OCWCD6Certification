<html>
<body>
Include Action Header here:
<jsp:include page="parametrizedHeader.jsp" >
    <jsp:param name="example" value="Test" />
    <jsp:param name="parametrized" value="${param.parametrized}"/>
</jsp:include>
The header has been included
</body>
</html>