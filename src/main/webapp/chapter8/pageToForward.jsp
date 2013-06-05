It will not appear on the forwarded JSP because the buffer will be cleared
<jsp:forward page="forwardDestination.jsp">
    <jsp:param name="forwardedParameter" value="Forwarded Value"/>
</jsp:forward>