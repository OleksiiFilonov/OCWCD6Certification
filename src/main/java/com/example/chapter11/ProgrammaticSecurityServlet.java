package com.example.chapter11;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProgrammaticSecurityServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        final PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html><body>");
        if(request.isUserInRole("AdminServlet")) {
            out.println("<h1>Admin User</h1>");
        } else if(request.isUserInRole("MemberServlet")) {
            out.println("<h1>Member User</h1>");
        } else if(request.isUserInRole("GuestServlet")) {
            out.println("<h1>Guest User</h1>");
        } else {
            out.println("<h1>Nobody User</h1>");
        }
        if(request.getUserPrincipal() != null) {
            out.println("request.getUserPrincipal().getName():" + request.getUserPrincipal().getName());
        }
        out.println("</html></body>");
    }

}
