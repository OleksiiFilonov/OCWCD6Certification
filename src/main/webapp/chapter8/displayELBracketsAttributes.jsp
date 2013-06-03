<%  pageContext.setAttribute("pageAttribute", "Page Attribute");
    pageContext.setAttribute("shared.complex.attribute", "Page Context Complex Shared Attribute"); %>
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
                <td>${pageScope["shared.complex.attribute"]}</td>
            </tr>
            <tr>
                <td>request</td>
                <td>${requestScope["shared.complex.attribute"]}</td>
            </tr>
            <tr>
                <td>session</td>
                <td>${sessionScope["shared.complex.attribute"]}</td>
            </tr>
            <tr>
                <td>application</td>
                <td>${applicationScope["shared.complex.attribute"]}</td>
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
    Cookie: ${cookie.JSESSIONID}<br/>
    Header: ${header.location}<br/>
</body>
</html>