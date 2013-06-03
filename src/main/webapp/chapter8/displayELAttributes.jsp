<%  pageContext.setAttribute("pageAttribute", "Page Attribute");
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
                <td>${pageAttribute}</td>
            </tr>
            <tr>
                <td>request</td>
                <td>${requestAttribute}</td>
            </tr>
            <tr>
                <td>session</td>
                <td>${sessionAttribute}</td>
            </tr>
            <tr>
                <td>application</td>
                <td>${applicationAttribute}</td>
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
                <td>${pageScope.sharedNameAttribute}</td>
            </tr>
            <tr>
                <td>request</td>
                <td>${requestScope.sharedNameAttribute}</td>
            </tr>
            <tr>
                <td>session</td>
                <td>${sessionScope.sharedNameAttribute}</td>
            </tr>
            <tr>
                <td>application</td>
                <td>${applicationScope.sharedNameAttribute}</td>
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
                <td>${param.requestParameter}</td>
            </tr>
            <tr>
                <td>servlet</td>
                <td>${pageContext.servletConfig.getInitParameter("jspConfigInitParameter")}</td>
            </tr>
            <tr>
                <td>application</td>
                <td>${initParam.jspContextParam}</td>
            </tr>
        </tbody>
    </table><br/>
    Cookie: ${cookie.JSESSIONID.value}<br/>
    Header: ${header.host} <br/>

    paramValues: ${paramValues.requestParameter[0]}<br/>
    headerValues: ${headerValues.Accept[0]} <br/>
</body>
</html>