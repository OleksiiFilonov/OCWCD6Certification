<html>
<body>
    <jsp:useBean id="employee" class="com.example.chapter8.Employee" >
        <jsp:setProperty name="employee" property="firstName" value="First Name"/>
        <jsp:setProperty name="employee" property="lastName" value="Last Name"/>
        <jsp:setProperty name="employee" property="id" value="7"/>
    </jsp:useBean>
    
    employee.firstName = ${employee.firstName} <br/>
    employee["firstName"] = ${employee["firstName"]}<br/>
    employee.noProperty = will cause a javax.el.PropertyNotFoundException<br/>
    employee["noProperty"] = will cause a javax.el.PropertyNotFoundException<br/>
    employee.firstName-LastName = try to make substraction from "First Name" - "Last Name" <br/>
</body>
</html>