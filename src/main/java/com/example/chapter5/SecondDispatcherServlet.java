package com.example.chapter5;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondDispatcherServlet extends HttpServlet {

	private static final String BR = "<br/>";
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		writer.println("forwarded query string is: " + req.getQueryString() + BR);
		Enumeration<String> attribNames = req.getAttributeNames();
		writer.println("Set of parameters " + BR);
		while(attribNames.hasMoreElements()) {
			String attribName =attribNames.nextElement();
			writer.println(attribName + "=" + req.getAttribute(attribName) + BR);
		}
		writer.println("original forwarded query string is: " + req.getAttribute("javax.servlet.forward.query_string") + BR);
		
	}

}
