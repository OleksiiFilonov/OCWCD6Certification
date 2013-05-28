package com.example.chapter5;

import java.util.logging.Logger;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

public class SessionObjectExample implements HttpSessionBindingListener, HttpSessionActivationListener {

    private static Logger logger = Logger.getLogger(SessionObjectExample.class.getName());

    static {
        logger.setUseParentHandlers(true);
    }

    @Override
    public void valueBound(final HttpSessionBindingEvent sessionBindingEvent) {
        logger.info("SessionObjectExample has been placed to session");
    }

    @Override
    public void valueUnbound(final HttpSessionBindingEvent sessionBindingEvent) {
        logger.info("SessionObjectExample has been removed from session");
    }

    @Override
    public void sessionDidActivate(final HttpSessionEvent sessionEvent) {
        logger.info("SessionObjectExample did activate");
    }

    @Override
    public void sessionWillPassivate(final HttpSessionEvent sessionEvent) {
        logger.info("SessionObjectExample will passivate");
    }

}
