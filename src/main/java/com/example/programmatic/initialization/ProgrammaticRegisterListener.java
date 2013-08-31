package com.example.programmatic.initialization;

import static com.example.programmatic.initialization.ProgrammaticListenerInitializer.MAPPING_URL;

import java.util.logging.Logger;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class ProgrammaticRegisterListener implements ServletRequestListener {

	private static final Logger logger = Logger.getLogger(ProgrammaticRegisterListener.class.getName());

	@Override
	public void requestInitialized(final ServletRequestEvent event) {
		final HttpServletRequest httpRequest = (HttpServletRequest) event.getServletRequest();
		if (MAPPING_URL.equals(httpRequest.getRequestURI())) {
			logger.info("Programmatic ServletRequestListener works perfectly for URI: " + MAPPING_URL);
		}
	}

	@Override
	public void requestDestroyed(final ServletRequestEvent event) {

	}
}
