<%@ taglib uri="dummyTagURI" prefix="custom" %>
<%@ taglib uri="mapAnotherDummyURI" prefix="another" %>
<html>
<body>
    Page for testing simple tag handler support with empty body<br/>
    <h1><custom:dummyTag attribute="Go to the bed"/></h1>
    <br/>
    and the same class, but another tld<br/>
    <h1>
        <another:anotherDummyTag>
            <jsp:attribute name="attribute">Drink Some Water!</jsp:attribute>
        </another:anotherDummyTag>
    </h1>
</body>
</html>