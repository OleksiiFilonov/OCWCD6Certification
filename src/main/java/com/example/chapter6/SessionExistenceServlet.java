package com.example.chapter6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionExistenceServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        final PrintWriter out = response.getWriter();
        out.println("<html><body>");
        HttpSession session = request.getSession(false);

        if(session == null) {
            out.println("Session is null here ");
            out.println("<a href=\"" + response.encodeRedirectURL("form.html") + "\">click me</a>");

        }
        session = request.getSession();
        if(session.isNew()) {
            out.println("This session is new");
        } else {
            out.println("This is an excisted session");
        }
        out.println("<a href=\"" + response.encodeURL("form.html") + "\">click me</a> </br>");
        out.println("Session information" + "</br>");
        out.println("Creation time: " + session.getCreationTime() + "</br>");
        out.println("Last Accessed Time: " + session.getLastAccessedTime() + "</br>");
        out.println("Max inactive interval: " + session.getMaxInactiveInterval() + "</br>");
        out.println("Cookies" + "</br>");
        final Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            for(final Cookie cookie : cookies) {
                out.println(cookie.getName() + ":" + cookie.getValue() + ":" + cookie.getMaxAge() + "</br>");
            }
        }
        out.println("</html></body>");
    }

}
