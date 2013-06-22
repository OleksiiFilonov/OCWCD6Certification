package com.example.chapter11;

import static java.lang.System.out;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExtensionMappingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void init() {
		out.println("Load " + ExtensionMappingServlet.class.getName());
	}

	@Override
	public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
		final PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>Extension mapping</h1>");
		out.println("</body></html>");
	}

}
