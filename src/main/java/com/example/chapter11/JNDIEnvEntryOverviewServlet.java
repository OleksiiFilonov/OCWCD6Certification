package com.example.chapter11;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JNDIEnvEntryOverviewServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
		final PrintWriter out = response.getWriter();
		out.println("<html><body>");
		Long counter = null;
		try {
			final Context ctx = new InitialContext();
			counter = (Long) ctx.lookup("java:comp/env/enventry/someName");
		} catch (final NamingException exc) {
			System.err.println(exc);
		}
		out.print("<h1>");
		out.print(String.valueOf(counter));
		out.println("</h1>");
		out.println("</body></html>");
	}
}
