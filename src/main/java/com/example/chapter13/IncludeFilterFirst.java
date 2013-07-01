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

public class IncludeFilterFirst implements Filter {

	private FilterConfig filterConfig;

	@Override
	public void init(final FilterConfig filterConfig) {
		this.filterConfig = filterConfig;
	}

	@Override
	public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain filterChain)
			throws IOException, ServletException {
		final HttpServletRequest httpRequest = (HttpServletRequest) request;
		getGlobal().log(Level.INFO,
				IncludeFilterFirst.class.getCanonicalName() + " for request " + httpRequest.getRequestURI());
		filterChain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}
}
