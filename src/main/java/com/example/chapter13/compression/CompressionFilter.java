package com.example.chapter13.compression;

import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CompressionFilter implements Filter {

	private static final String GZIP = "gzip";

	private FilterConfig filterConfig;

	private ServletContext servletContext;

	@Override
	public void init(final FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		servletContext = filterConfig.getServletContext();
		servletContext.log(filterConfig.getFilterName() + " initialized");
	}

	@Override
	public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
			throws IOException, ServletException {
		final HttpServletRequest httpRequest = (HttpServletRequest) request;
		final HttpServletResponse httpResponse = (HttpServletResponse) response;
		final String encoding = httpRequest.getHeader("Accept-Encoding");
		if (encoding.indexOf(GZIP) > -1) {
			final CompressionResponseWrapper respWrapper = new CompressionResponseWrapper(httpResponse);
			respWrapper.setHeader("Content-Encoding", GZIP);
			chain.doFilter(httpRequest, respWrapper);
			final GZIPOutputStream gzipOutStream = respWrapper.getGZIPOutputStream();
			gzipOutStream.finish();
			servletContext.log(filterConfig.getFilterName() + " request has been zipped");
		} else {
			chain.doFilter(httpRequest, httpResponse);
			servletContext.log(filterConfig.getFilterName() + " request hasn't been zipped");
		}
	}

	@Override
	public void destroy() {
		filterConfig = null;
		servletContext = null;
	}

}
