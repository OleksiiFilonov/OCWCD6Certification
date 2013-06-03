<%	pageContext.setAttribute("pageAttribute", "Page Attribute");
	pageContext.setAttribute("sharedNameAttribute", "Page Context Shared Attribute"); %>
<html>
<body>
	<h1>Display Parameters JSP using implicit objects</h1><br>
	<table>
		<thead>
			<tr>
				<td>Scope</td>
				<td>Value</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>page</td>
				<td><%=pageContext.getAttribute("pageAttribute") %></td>
			</tr>
			<tr>
				<td>request</td>
				<td><%=request.getAttribute("requestAttribute") %></td>
			</tr>
			<tr>
				<td>session</td>
				<td><%=session.getAttribute("sessionAttribute") %></td>
			</tr>
			<tr>
				<td>application</td>
				<td><%=application.getAttribute("applicationAttribute") %></td>
			</tr>
		</tbody>
	</table><br/>
	
	<h1>Display Parameters JSP using <b>pageContext</b></h1><br>
	<table>
		<thead>
			<tr>
				<td>Scope</td>
				<td>Value</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>page</td>
				<td><%=pageContext.getAttribute("sharedNameAttribute") %></td>
			</tr>
			<tr>
				<td>request</td>
				<td><%=pageContext.getAttribute("sharedNameAttribute", PageContext.REQUEST_SCOPE) %></td>
			</tr>
			<tr>
				<td>session</td>
				<td><%=pageContext.getAttribute("sharedNameAttribute", PageContext.SESSION_SCOPE) %></td>
			</tr>
			<tr>
				<td>application</td>
				<td><%=pageContext.getAttribute("sharedNameAttribute", PageContext.APPLICATION_SCOPE) %></td>
			</tr>
		</tbody>
	</table><br/>

	<h1>Display Parameters</h1><br>
	<table>
		<thead>
			<tr>
				<td>Scope</td>
				<td>Value</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>request</td>
				<td><%= request.getParameter("requestParameter") %></td>
			</tr>
			<tr>
				<td>servlet</td>
				<td><%=config.getInitParameter("jspConfigParameter") %></td>
			</tr>
			<tr>
				<td>application</td>
				<td><%=application.getInitParameter("jspContextParam") %></td>
			</tr>
		</tbody>
	</table><br/>
</body>
</html>