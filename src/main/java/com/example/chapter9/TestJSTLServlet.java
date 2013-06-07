package com.example.chapter9;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestJSTLServlet extends HttpServlet {

    private static final String[] STRINGS_ARRAY = new String[] { "zero", "one", "two", "three", "four", "five", "six",
            "7", "8", "9", "10" };
    private static final String COMPLEX_ATTRIBUTE = "<b>This <strong>attribute</strong> should 'be' \"encoded\"</b>";
    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,
            IOException {
        request.setAttribute("attributeToEncode", COMPLEX_ATTRIBUTE);
        request.setAttribute("array", STRINGS_ARRAY);
        final RequestDispatcher view = request.getRequestDispatcher("testJSTL.jsp");
        view.forward(request, response);
    }
}
