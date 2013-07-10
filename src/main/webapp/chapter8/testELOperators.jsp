<%@ taglib uri="CustomELFunctionLib" prefix="test" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test Addition and Multiplication EL functions</title>
</head>
<body>
	<h1>Arithmetic</h1>
	Addition strings "2" + "3":  ${"2" + "3"} <br/>
	Addition integers 2+3:  ${2+3} <br/>
	Addition 2 + noSuchValue:  ${2+noSuchValue} <br/>
	Addition {"2" + 3} :  ${"2"+3} <br/>
	Substruction {"2" - 3}: ${"2" - 3} <br/>
	Substruction "11" - noSuchValue: ${"11" - noSuchValue} <br/>
	Division {"2"/0} - get infinity: ${"2" / 0} <br/>
	Division "5" div "3": ${"5" div "3"} <br/>
	Division {"5" div noSuchValue}: ${"5" div noSuchValue} <br/>
	Remainder(you can't use remainder to zero) {8 % 3}: ${8 % 3}<br/>
	Remainder(you can't use remainder to zero) {"10" mod "5"}: ${"10" mod "5"} <br/>
	
	<h1>Logical</h1>
	blVar=true;<br/>
	<%	boolean blVar = true;
		pageContext.setAttribute("blVar", blVar);
	%>
	AND noSuchValue and null: ${noSuchValue and null} <br/>
	AND true and "one": ${true and "one"} <br/>
	AND true && "blVar": ${true && blVar} <br/>
	AND "true" && "false": ${"true" && "false"} <br/>
	OR noSuchValue or null: ${noSuchValue or null} <br/>
	OR true or "one": ${true or "one"} <br/>
	OR true || "blVar": ${true || blVar} <br/>
	OR "true" || "false": ${"true" || "false"} <br/>
	NOT noSuchValue: ${not noSuchValue} <br/>
	NOT not "one": ${not "one"} <br/>
	NOT !"blVar": ${!blVar} <br/>
	NOT !null: ${!null} <br/>
	
	<h1>Relational</h1>
	Equals "1" == "2" ${"1" == "2"}<br/>
	Equals "test" eq "test" ${"test" eq "test"}<br/>
	Equals false == noSuchValue ${false == noSuchValue}<br/>
	Equals null == noSuchValue ${null == noSuchValue}<br/>
	Not Equals false != noSuchValue ${false != noSuchValue}<br/>
	Not Equals true != noSuchValue ${true != noSuchValue}<br/>
	Not Equals "1" != "2" ${"1" != "2"}<br/>
	Not Equals "test" ne "test" ${"test" ne "test"}<br/>
	Less than "1" < "2" ${"1" < "2"}<br/>
	Less "test" lt "test" ${"test" lt "test"}<br/>
	Less "test1" lt "test" ${"test1" lt "test"}<br/>
	Less "test" < "test1" ${"test" < "test1"}<br/>
	Greater than "1" > "2" ${"1" > "2"}<br/>
	Greater "test" gt "test" ${"test" gt "test"}<br/>
	Greater "test1" gt "test" ${"test1" gt "test"}<br/>
	Greater "test" > "test1" ${"test" > "test1"}<br/>
	Less then or equal to "1" <= "2" ${"1" < "2"}<br/>
	Less then or equal to "test" le "test" ${"test" le "test"}<br/>
	Less then or equal to "test1" le "test" ${"test1" le "test"}<br/>
	Less then or equal to "test" <= "test1" ${"test" <= "test1"}<br/>
	Greater then or equal to "1" >= "2" ${"1" >= "2"}<br/>
	Greater then or equal to "test" ge "test" ${"test" ge "test"}<br/>
	Greater then or equal to "test1" ge "test" ${"test1" ge "test"}<br/>
	Greater then or equal to "test" >= "test1" ${"test" >= "test1"}<br/>
	{false <= true} :${false <= true}<br/>
	{true < false} :${true < false}
	<h2>you can't do +/- for strings. It is only for digits. you can't perform {"one" + "two"} - 500 error. Concatenate string just typing one by one</h2><br/>
	<h2>there are no single logic sign operation except "!" {true & true} - 500 error</h2><br/>
	
	<h1>empty</h1>
	EMPTY null: ${empty null } <br/>
	NOT EMPTY noSuchValue: ${!empty noSuchValue} <br/>
	EMPTY blVar: ${empty blVar} <br/>
	EMPTY "" string: ${empty ""} <br/>
	EMPTY "    " three space string: ${empty "    "} <br/>
</body>
</html>