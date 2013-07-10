package com.example.chapter6;

import static com.example.chapter6.AddSessionAttributeServlet.TEST_LISTENER_ATTRIBUTE;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RemoveSessionAttributeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        final PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("TestListenerAttribute has been removed");
        final HttpSession session = request.getSession();
        session.removeAttribute(TEST_LISTENER_ATTRIBUTE);
        out.println("</html></body>");
    }
}
