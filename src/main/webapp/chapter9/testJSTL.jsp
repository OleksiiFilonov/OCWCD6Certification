<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
	<h1>Test core tag library</h1>
	Encoded argument: <c:out value="${attributeToEncode}"/> - by default it is true <br/>
	Not Encoded argument: <c:out value="${attributeToEncode}" escapeXml="false"/> <br/>
	Default value <c:out value="${param.NoSuchParameters}">This is default value</c:out> <br/>
	The whole for each:
	<table>
		<c:forEach items="${array}" var="element" varStatus="iterator">
			<tr>
				<td>${iterator.count}</td>
				<td>${element}</td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	Iterate over every third step
	<table>
		<c:forEach items="${array}" step="3" var="element" varStatus="iterator">
			<tr>
				<td>${iterator.count}</td>
				<td>${element}</td>
			</tr>
		</c:forEach>
	</table><br/>
	Start from second step and end at 8 step
	<table>
		<c:forEach items="${array}" begin="2" end="8" var="element" varStatus="iterator">
			<tr>
				<td>${iterator.count}</td>
				<td>${element}</td>
			</tr>
		</c:forEach>
	</table><br/>
	Start from begin iterate to 8 step over 3
	<table>
		<c:forEach items="${array}" end="8" step="3" var="element" varStatus="iterator">
			<tr>
				<td>${iterator.count}</td>
				<td>${element}</td>
			</tr>
		</c:forEach>
	</table><br/>
</body>
</html>