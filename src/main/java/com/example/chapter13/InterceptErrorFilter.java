package com.example.chapter13;

import static java.util.logging.Logger.getGlobal;

import java.io.IOException;
import java.util.logging.Level;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class InterceptErrorFilter implements Filter {

	private FilterConfig filterConfig;

	private String someInitParam;

	@Override
	public void init(final FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		someInitParam = filterConfig.getInitParameter("initParam");
		getGlobal().log(
				Level.INFO,
				InterceptErrorFilter.class.getCanonicalName() + " filter is initialized with parameter "
						+ someInitParam);
	}

	@Override
	public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
			throws IOException, ServletException {
		final HttpServletRequest httpRequest = (HttpServletRequest) request;
		getGlobal()
				.log(Level.INFO,
						InterceptErrorFilter.class.getCanonicalName() + " catched the error for "
								+ httpRequest.getRequestURI());
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		getGlobal().log(Level.INFO, InterceptErrorFilter.class.getCanonicalName() + " filter is destroyed");
	}

}
