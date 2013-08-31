package com.example.programmatic.initialization;

import static com.example.programmatic.initialization.ProgrammaticListenerInitializer.INIT_PARAMETER;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OutputInitParameterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String KEY_VALUE_TEMPLATE = "%s: %s</br>";
	private static final String OUTPUT_TEMPLATE = "<h2>Initialized with parameter: '%s'</h2></br>";

	@Override
	public void doGet(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
		final PrintWriter out = res.getWriter();
		out.println("<h1>Programmaticaly Initialized Servlet</h1></br>");
		out.println(String.format(OUTPUT_TEMPLATE, getServletConfig().getInitParameter(INIT_PARAMETER)));
		final Map<String, ? extends ServletRegistration> servletRegistrations = getServletContext()
				.getServletRegistrations();
		for (final Entry<String, ? extends ServletRegistration> entry : servletRegistrations.entrySet()) {
			out.println(String.format(KEY_VALUE_TEMPLATE, entry.getKey(), entry.getValue().getClassName()));
		}
	}

}
