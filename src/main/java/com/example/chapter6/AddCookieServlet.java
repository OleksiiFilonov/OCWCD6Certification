package com.example.chapter6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCookieServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		Cookie changedDefaultCookie = new Cookie("ChangedDefaultCookieName", "Changed Cookie Value");
		Cookie changedInterval30Cookie = new Cookie("changedInterval30Cookie", "Interval set to 30 seconds");
		changedInterval30Cookie.setMaxAge(60);
		response.addCookie(changedDefaultCookie);
		response.addCookie(changedInterval30Cookie);
		out.println("</html></body>");
	}
}
