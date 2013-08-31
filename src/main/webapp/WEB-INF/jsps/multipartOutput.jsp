<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
    <h1>Multipart Response Page</h1>
	<table border="1">
		<tbody>
			<c:forEach var="part" items="${pageContext.request.parts}">
			 <tr>
			     <td>
                    ${part.name}
                </td>
			     <td>
                    ${part.contentType}
                </td>
			     <td>
                    ${part.headerNames}
                </td>
			     <td>
                    ${part.size}
                </td>
			     <td>
                    ${part.getHeader("content-disposition")}
                </td>
			     <td>
                    ${part.getHeader("content-type")}
                </td>
             </tr>
            </c:forEach>
		</tbody>
	</table>
</body>
</html>