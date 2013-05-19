<html>
	<body>
		DispatchParameters: <%=request.getQueryString() %>
		DispatchParameters from previous page <%=request.getAttribute("javax.servlet.forward.query_string") %>
	</body>
</html>