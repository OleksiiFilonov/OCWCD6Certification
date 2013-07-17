package com.example.annotations;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("*")
public class WrapEverythingFilter implements Filter {

	private static Logger LOG = Logger.getLogger(WrapEverythingFilter.class.getName());

	private FilterConfig config;

	@Override
	public void init(final FilterConfig config) throws ServletException {
		this.config = config;
	}

	@Override
	public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
			throws ServletException, IOException {
		LOG.info("WrapEverythingFilter Wrapped request " + request);
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}

}
