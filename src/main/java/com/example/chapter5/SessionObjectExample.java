package com.example.chapter5;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class SessionObjectExample implements HttpSessionBindingListener {

	public void valueBound(HttpSessionBindingEvent arg0) {
		Logger.getGlobal().log(Level.INFO, "SessionObjectExample has been placed to session");
	}

	public void valueUnbound(HttpSessionBindingEvent arg0) {
		Logger.getGlobal().log(Level.INFO, "SessionObjectExample has been removed from session");
	}


}
