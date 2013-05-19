<jsp:forward page="secondDispatch.jsp?secondDispatchParam1=secondDispatchParam1"></jsp:forward>
<html>
	<body>
		DispatchParameters: <%=request.getQueryString() %>
		<%-- The parameters from very original request will be shown --%>
		DispatchParameters from previous page <%=request.getAttribute("javax.servlet.forward.query_string") %>
	</body>
</html>