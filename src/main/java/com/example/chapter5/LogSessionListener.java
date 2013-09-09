package com.example.chapter5;

import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//@WebListener
public class LogSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(final HttpSessionEvent httpSessionEvent) {
		Logger.getGlobal().log(Level.INFO, "Session has been created " + httpSessionEvent);
	}

	@Override
	public void sessionDestroyed(final HttpSessionEvent httpSessionEvent) {
		Logger.getGlobal().log(Level.INFO, "Session has been destroyed " + httpSessionEvent);
		final Enumeration attributes = httpSessionEvent.getSession().getAttributeNames();
		while (attributes.hasMoreElements()) {
			Logger.getGlobal().log(Level.INFO, "attribute Name: " + attributes.nextElement());
		}
	}

}
