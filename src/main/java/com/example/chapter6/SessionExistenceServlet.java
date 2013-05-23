package com.example.chapter6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionExistenceServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		HttpSession session = request.getSession(false);
		
		if(session == null) {
			out.println("Session is null here ");
			out.println("<a href=\"" + response.encodeRedirectURL("form.html") + "\">click me</a>");
			
		}
		session = request.getSession();
		if(session.isNew()) {
			out.println("This session is new");
		} else {
			out.println("This is an excisted session");
		}
		out.println("<a href=\"" + response.encodeURL("form.html") + "\">click me</a>");
		out.println("</html></body>");
	}

}
