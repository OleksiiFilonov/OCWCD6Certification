<html>
<body>
"example" parameter before include: "${param.example}"
Include Action Header here:
<jsp:include page="parametrizedHeader.jsp" >
    <jsp:param name="example" value="Test" />
    <jsp:param name="parametrized" value="${param.parametrized}"/>
</jsp:include>
<br/>
The header has been included<br/>
"example" parameter after include: "${param.example}" - parameter changed only inside included file 
</body>
</html>