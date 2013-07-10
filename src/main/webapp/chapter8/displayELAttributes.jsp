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
                <td>${sharedNameAttribute}</td>
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
    <h2>Cookies are added to the response will appear in the request in a new request,
    because EL cookies are a request cookies,
    In EL Cookie is an object cookie.someCookieName returns object</h2>
    just to see cookie object cookie.cookieName - ${cookie.cookieName}<br/>
    just to see cookie cookie.cookieName.value - ${cookie.cookieName.value}<br/>
    just to see cookie cookie.cookieName.maxAge - ${cookie.cookieName.maxAge}<br/>
    just to see cookie cookie.cookieName.path - ${cookie.cookieName.path}<br/>
    just to see cookie cookie.cookieName.domain - ${cookie.cookieName.domain}<br/>
    just to see cookie cookie.cookieName.secure - ${cookie.cookieName.secure}<br/>
    just to see cookie cookie.cookieName.httpOnly - ${cookie.cookieName.httpOnly}<br/>
    
    <h2>Test Header and header values. In EL header and headerValues are inside a request, so if you add any header to response you won't see them</h2><br/>
    header['headerNameSingle'] = "${header['headerNameSingle']}"<br/>
    header.headerName = "${header.headerName}"<br/>
    headerValues.headerName = "${headerValues.headerName}"<br/>
    headerValues.headerName[0] = "${headerValues.headerName[0]}"<br/>
    
    Cookie: ${cookie.JSESSIONID.value}<br/>
    header.host: ${header.host} <br/>
    header["User-Agent"]: ${header["User-Agent"]} <br/>
    header.User-Agent: ${header.User-Agent} <br/>

    paramValues: ${paramValues.requestParameter[0]}<br/>
    headerValues: ${headerValues.Accept[0]} <br/>
    If sends hobbies=one&hobbies=two <br/>
    paramValues.hobbies = "${param.hobbies}"<br/>
    paramValues.hobbies[0]-paramValues.hobbies[1] = ${paramValues.hobbies[0]}-${paramValues.hobbies[1]}<br/>
    <h2>initParam for <i>context</i> init parameters - not for servelt init parameters </h2><br/>
    initParam.dbJNDIName = ${initParam.dbJNDIName}
    
</body>
</html>