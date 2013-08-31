package com.example.programmatic.initialization;

import java.util.EnumSet;
import java.util.EventListener;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebListener;

@WebListener
public class ProgrammaticListenerInitializer implements ServletContextListener {

	public static final String MAPPING_URL = "/programmatic";
	public static final String INIT_PARAMETER = "textParameter";

	@Override
	public void contextInitialized(final ServletContextEvent event) {
		final ServletContext ctx = event.getServletContext();
		addServletByClassName(ctx);
		addFilterByClass(ctx);
		addListenerInstanse(ctx);
	}

	private void addServletByClassName(final ServletContext ctx) {
		final ServletRegistration.Dynamic dynamicServletClassName = ctx.addServlet(
				"outputInitParameterServletClassName",
				"com.example.programmatic.initialization.OutputInitParameterServlet");
		dynamicServletClassName.addMapping(MAPPING_URL);
		dynamicServletClassName.setInitParameter(INIT_PARAMETER, "servlet has been initialized programmaticaly");
	}

	private void addFilterByClass(final ServletContext ctx) {
		final FilterRegistration.Dynamic filterClassRegistration = ctx.addFilter("filterOutputInitParameterClass",
				FilterOutputInitParameter.class);
		filterClassRegistration.setInitParameter(INIT_PARAMETER, "filter has been initialized programmaticaly");
		filterClassRegistration.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, MAPPING_URL);
	}

	private void addListenerInstanse(final ServletContext ctx) {
		try {
			final EventListener listener = ctx.createListener(ProgrammaticRegisterListener.class);
			ctx.addListener(listener);
		} catch (final ServletException e) {
			System.err.println("Exception while listener initialization: " + e.getLocalizedMessage());
		}
	}

	@Override
	public void contextDestroyed(final ServletContextEvent event) {

	}

}
