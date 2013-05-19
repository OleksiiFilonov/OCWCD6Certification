package com.example.chapter5;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InipParamAttributeReaderServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter responseWriter = response.getWriter();
		
		responseWriter.println("Servlet init parameters: <br/>");
		@SuppressWarnings("unchecked")
		Enumeration<String> servletInitParams = (Enumeration<String>)getServletConfig().getInitParameterNames();
		while (servletInitParams.hasMoreElements()) {
			String paramName = servletInitParams.nextElement();
			responseWriter.println("Parameter Name: " + paramName + " Parameter Value: " + getServletConfig().getInitParameter(paramName) + "<br/>");
		}
		
		responseWriter.println("Servlet context init parameters: <br/>");
		@SuppressWarnings("unchecked")
		Enumeration<String> servletContextInitParams = (Enumeration<String>)getServletContext().getInitParameterNames();
		while(servletContextInitParams.hasMoreElements()) {
			String contextParamName = servletContextInitParams.nextElement();
			responseWriter.println("Context Parameter Name: " + contextParamName + " Parameter Value: " + getServletContext().getInitParameter(contextParamName) + "<br/>");
		}
		
/*		responseWriter.println("Application attributes: <br/>");
		@SuppressWarnings("unchecked")
		Enumeration<String> attributeNames = getServletContext().getAttributeNames();
		while (attributeNames.hasMoreElements()) {
			String attrubuteName = attributeNames.nextElement();
			responseWriter.println("App atribute name: " + attrubuteName + " App attribute value: " + getServletContext().getAttribute(attrubuteName) + "<br/>");
		}*/
		
		responseWriter.println("Extract Application Attribute DB JNDI Name <br/>");
		ContextAttributeObject dbNameObject = (ContextAttributeObject) getServletContext().getAttribute("dbJNDIObject");
		responseWriter.println("Connection Name: " + dbNameObject.getParamName() + " Connection Value: " + dbNameObject.getParamValue() + "<br/>");
		
		

	}
	
	

}
