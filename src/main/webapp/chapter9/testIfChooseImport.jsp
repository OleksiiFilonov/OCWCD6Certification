<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
    <h1>Test If Choose When Otherwise Import</h1>
    <c:if test="${ 1 > 2 }">
        If you see it it means 1 > 2
    </c:if>
    <br/>
    Pass one of the parameter <b>when</b> along with the argument<br/>
    <c:choose>
        <c:when test="${param.when eq null}" >
            Nothing has been passed
        </c:when>
        <c:when test="${param.when > 0}" >
            Something greater then zero has been passed<br/>
            <c:import url="includeCout.jsp">
                <c:param name="passed" value="${param.when}"/>
            </c:import>
            <br/>
            Paste something stupid outside the site
            <c:import url="http://jquery.com/jquery-wp-content/themes/jquery/css/base.css?v=1"/>
        </c:when>
        <c:otherwise>
            Something unpredictable has been passed<br/>
            <c:import url="includeCout.jsp">
                <c:param name="passed" value="${param.when}"/>
            </c:import>
            <c:import url="https://media.one.ubuntu.com/media/6998/img/hd/u1_logo_med.png"/>
        </c:otherwise>
    </c:choose>
</body>
</html>