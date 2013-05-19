package com.example.chapter5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IllegalStateExceptionServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("Write some unuseful staff to see IllegalStateException after forward");
		writer.flush();
		
		RequestDispatcher reqDispatcher = request.getRequestDispatcher("/shouldntSeeThisPage.html");
		reqDispatcher.forward(request, response);
		
	}

}
