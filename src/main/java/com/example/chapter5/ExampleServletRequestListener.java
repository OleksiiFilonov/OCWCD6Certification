package com.example.chapter5;

import java.util.logging.Logger;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class ExampleServletRequestListener implements ServletRequestListener {

    private static Logger LOG = Logger.getLogger(ExampleServletRequestListener.class.getName());

    static {
        LOG.setUseParentHandlers(true);
    }

    @Override
    public void requestInitialized(final ServletRequestEvent event) {
        final HttpServletRequest request = (HttpServletRequest)event.getServletRequest();
        LOG.info("Request initialized :" + request.getRequestURL());
    }

    @Override
    public void requestDestroyed(final ServletRequestEvent event) {
        final HttpServletRequest request = (HttpServletRequest)event.getServletRequest();
        LOG.info("Request destroyed :" + request.getRequestURI());
    }

}
