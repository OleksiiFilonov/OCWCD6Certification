package com.example.chapter6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeCookiesSessionServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;


	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		for (Cookie cookie : request.getCookies()) {
			switch (cookie.getName()) {
				case "ChangedDefaultCookieName": 
					cookie.setValue("changed ChangedDefaultCookieName value");
					cookie.setMaxAge(20);
					response.addCookie(cookie);
					break;
				case "changedInterval30Cookie": 
					cookie.setValue("changed changedInterval30Cookie value but setMax Age doesn't work until you add it to response once again");
					cookie.setMaxAge(10);
					break;
			}
		}
		out.println("</html></body>");
	}	

}
