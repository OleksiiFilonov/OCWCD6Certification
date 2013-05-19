package com.example.chapter5;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class LogSessionListener implements HttpSessionListener{

	public void sessionCreated(HttpSessionEvent httpSessionEvent) {
		Logger.getGlobal().log(Level.INFO, "Session has been created " + httpSessionEvent);
	}

	public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
		Logger.getGlobal().log(Level.INFO, "Session has been destroyed " + httpSessionEvent);
	}

}
