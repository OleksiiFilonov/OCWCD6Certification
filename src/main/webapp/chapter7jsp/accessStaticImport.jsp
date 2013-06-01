<%@page import="java.util.logging.Logger"%>
<%@ page import="com.example.chapter7.AccessFromJSP,java.util.Date" %>
<%-- This is an example of declaration --%>
<%! private int counter;%>
<%! private static Logger logger = Logger.getLogger("accessStaticImport log"); %>
<%! static { logger.setUseParentHandlers(true);} %>

<%! public void jspInit() {
	logger.info("accessStaticImport JSP is loaded");
} %>

<%! public void jspDestroy() {
	logger.info("accessStaticImport JSP is unloaded");
} %>
<html>
	<body>
		I would like to access <%= AccessFromJSP.TEST_STRING %> <br/>
		<%-- This is a comment to scriplet --%> 
		<% Date currentDate = new Date(); %>
		<%-- This is an expression --%>
		Current Date expression: <%= currentDate %> <br/>
		Current Date out object <% out.println(currentDate); %> <br/>
		You accessed form <b><%= ++counter %></b> times <br/> 
	</body>
</html>