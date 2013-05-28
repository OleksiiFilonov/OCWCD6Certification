package com.example.chapter6;

import java.util.logging.Logger;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class ExampleHttpSessionAttributeListener implements HttpSessionAttributeListener {

    private static Logger logger = Logger.getLogger(ExampleHttpSessionAttributeListener.class.getName());

    static {
        logger.setUseParentHandlers(true);
    }

    @Override
    public void attributeAdded(final HttpSessionBindingEvent sessionBindingEvent) {
        logger.info("Add attribute for session: " + sessionBindingEvent.getSession().getId() + " name-"
                + sessionBindingEvent.getName() + ";value-" + sessionBindingEvent.getValue());
    }

    @Override
    public void attributeRemoved(final HttpSessionBindingEvent sessionBindingEvent) {
        logger.info("Remove attribute for session: " + sessionBindingEvent.getSession().getId() + " name-"
                + sessionBindingEvent.getName() + ";value-" + sessionBindingEvent.getValue());
    }

    @Override
    public void attributeReplaced(final HttpSessionBindingEvent sessionBindingEvent) {
        logger.info("Replace attribute for session: " + sessionBindingEvent.getSession().getId() + " name-"
                + sessionBindingEvent.getName() + ";value-" + sessionBindingEvent.getValue());
    }

}
