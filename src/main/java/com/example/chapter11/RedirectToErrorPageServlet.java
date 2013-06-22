package com.example.chapter11;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectToErrorPageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
		if (request.getParameter("exception") == null) {
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
		} else {
			throw new CaughtTestException("catch this exception with special error page");
		}
	}

}
