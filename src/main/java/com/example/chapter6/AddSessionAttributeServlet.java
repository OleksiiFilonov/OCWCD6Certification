package com.example.chapter6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddSessionAttributeServlet extends HttpServlet {

    public static final String TEST_LISTENER_ATTRIBUTE = "TestListenerAttribute";
    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        final PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("TestListenerAttribute has been added");
        final HttpSession session = request.getSession();
        session.setAttribute(TEST_LISTENER_ATTRIBUTE, "attribute has been added");
        out.println("</html></body>");
    }
}
