package com.example.chapter7;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddParametersToJSPServlet extends HttpServlet {

	private static final String SHARED_NAME_ATTRIBUTE = "sharedNameAttribute";
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("requestAttribute", "Request Attribute");
		request.setAttribute(SHARED_NAME_ATTRIBUTE, "Request Shared Attribute");
		HttpSession session = request.getSession();
		session.setAttribute("sessionAttribute", "Session Attribute");
		session.setAttribute(SHARED_NAME_ATTRIBUTE, "Session Shared Attribute");
		getServletContext().setAttribute("applicationAttribute", "Application Attribute");
		getServletContext().setAttribute(SHARED_NAME_ATTRIBUTE, "Application Shared Attribute");
		request.getRequestDispatcher("/chapter7jsp/displayAttributes.do?requestParameter=RequestParameter").forward(request, response);
	}

}
