package com.example.programmatic.initialization;

import static com.example.programmatic.initialization.ProgrammaticListenerInitializer.INIT_PARAMETER;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterOutputInitParameter implements Filter {

	private static final Logger logger = Logger.getLogger(FilterOutputInitParameter.class.getName());

	private static final String KEY_VALUE_TEMPLATE = "%s: %s";
	private static final String OUTPUT_TEMPLATE = "Initialized with parameter: '%s'";

	private FilterConfig config;

	@Override
	public void init(final FilterConfig config) throws ServletException {
		this.config = config;
	}

	@Override
	public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain)
			throws ServletException, IOException {
		logger.info(String.format(OUTPUT_TEMPLATE, config.getInitParameter(INIT_PARAMETER)));
		final Map<String, ? extends FilterRegistration> filterRegistrations = req.getServletContext()
				.getFilterRegistrations();
		for (final Entry<String, ? extends FilterRegistration> entry : filterRegistrations.entrySet()) {
			logger.info(String.format(KEY_VALUE_TEMPLATE, entry.getKey(), entry.getValue().getClassName()));
		}
		chain.doFilter(req, res);
	}

	@Override
	public void destroy() {

	}

}
