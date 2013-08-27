package com.example.asyncsupport;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.http.HttpServletRequest;

public class AsyncListenerLogger implements AsyncListener {

	private static Logger logger = Logger.getLogger(AsyncListenerLogger.class.getName());

	@Override
	public void onComplete(final AsyncEvent event) throws IOException {
		logger.info("Async handle completed for request URI: " + getRequestURI(event));
	}

	private String getRequestURI(final AsyncEvent event) {
		final HttpServletRequest httpReq = (HttpServletRequest) event.getSuppliedRequest();
		final String requestURI = (httpReq == null) ? "" : httpReq.getRequestURI();
		return requestURI;
	}

	@Override
	public void onTimeout(final AsyncEvent event) throws IOException {
		logger.info("Async handling timeout for request URI: " + getRequestURI(event));
	}

	@Override
	public void onError(final AsyncEvent event) throws IOException {
		logger.info("Error happaned while processing async request for URI: " + getRequestURI(event));
	}

	// call only when a new asynchronous cycle being initialized
	@Override
	public void onStartAsync(final AsyncEvent event) throws IOException {
		logger.info("Async handling was started for request URI: " + getRequestURI(event));
	}

}
