package com.example.chapter8;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddParametersToELJSPServlet extends HttpServlet {

	private static final String SHARED_NAME_ATTRIBUTE = "sharedNameAttribute";
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,
			IOException {
		request.setAttribute("requestAttribute", "Request Attribute");
		request.setAttribute(SHARED_NAME_ATTRIBUTE, "Request Shared Attribute");
		final HttpSession session = request.getSession();
		session.setAttribute("sessionAttribute", "Session Attribute");
		session.setAttribute(SHARED_NAME_ATTRIBUTE, "Session Shared Attribute");
		getServletContext().setAttribute("applicationAttribute", "Application Attribute");
		getServletContext().setAttribute(SHARED_NAME_ATTRIBUTE, "Application Shared Attribute");
		request.getRequestDispatcher("/chapter8/displayELAttributes.jsp?requestParameter=RequestParameter").forward(
				request, response);
	}

}
