package com.example.chapter5;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String howToDispatch = request.getParameter("dispatchParameter");
		
		switch (howToDispatch) {
			case "requestDispatcher" : {
				request.getRequestDispatcher("requestDispatcher.jsp").forward(request, response);
				break;
			}
			case "servletContextDispatcher" : {
				//getServletContext() must start with "/" otherwise - IllegalArgumentException
				getServletContext().getRequestDispatcher("/servletContextDispatcher.jsp").forward(request, response);
				break;
			}
			case "servletForward" : {
				request.getRequestDispatcher("/secondDispatcherServlet.do?jspparam1=jspvalue1&jspparam2=jspvalue2").forward(request, response);
				break;
			}			
			case "manyForwardDispatcher" : {
				request.getRequestDispatcher("/firstDispatch.jsp?param1=value1&param2=value2").forward(request, response);
				break;
			}
		}
	}

}
