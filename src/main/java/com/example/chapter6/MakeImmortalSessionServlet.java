package com.example.chapter6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MakeImmortalSessionServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		HttpSession session = request.getSession();
		//zero o less indicates session will never expire
		session.setMaxInactiveInterval(0);
		out.println("Session is immortal!");
		out.println("</html></body>");
	}

}
