package com.example.annotations;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "This is just a servlet to display Context path and Context value", urlPatterns = {
		"/informationServlet", "/informationServlet2", "/informationSerlvet3/", "/informationSerlvet4/*", "*.info" }, displayName = "PathsInformationServlet servlet Display Name", name = "PathsInformation")
public class PathsInformationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,
			IOException {
		final PrintWriter writer = response.getWriter();
		writer.println("<html><body>");
		writer.println(String.format("<h1>Contex path getServletContext().getContextPath(): \"%s\"</h1>",
				getServletContext().getContextPath()));
		writer.println(String.format("<h1>Servlet path request.getServletPath(): \"%s\"</h1>", request.getServletPath()));
		writer.println(String.format("<h1>Servlet Info request.getPathInfo() : \"%s\"</h1>", request.getPathInfo()));
		writer.println(String.format("<h1>Request URI request.getRequestURI() : \"%s\"</h1>", request.getRequestURI()));
		writer.println(String.format("<h1>Request URL request.getRequestURL() : \"%s\"</h1>", request.getRequestURL()));
		writer.println("</body></html>");
	}
}
