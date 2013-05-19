package com.example.chapter5;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ExampleServletContextListener implements ServletContextListener{

	public void contextInitialized(ServletContextEvent scevent) {
		ServletContext context = scevent.getServletContext();
		String paramName = "dbJNDIName";
		ContextAttributeObject attribute = new ContextAttributeObject(paramName, context.getInitParameter(paramName));
		context.setAttribute("dbJNDIObject", attribute);
		
	}

	public void contextDestroyed(ServletContextEvent sce) {
		Logger.getGlobal().log(Level.INFO, "Application context has been destroyed");
	}

}
