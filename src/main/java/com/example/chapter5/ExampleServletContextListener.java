package com.example.chapter5;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hsqldb.server.Server;

public class ExampleServletContextListener implements ServletContextListener {

    private Server hsqlServer;

    @Override
    public void contextInitialized(final ServletContextEvent scevent) {
        final ServletContext context = scevent.getServletContext();
        final String paramName = "dbJNDIName";
        final ContextAttributeObject attribute = new ContextAttributeObject(paramName,
                context.getInitParameter(paramName));
        context.setAttribute("dbJNDIObject", attribute);
        startHQSLLocalDatabase(context.getInitParameter("databaseName"), context.getInitParameter("databasePath"));

    }

    private void startHQSLLocalDatabase(final String databaseName, final String databasePath) {
        this.hsqlServer = new Server();
        this.hsqlServer.setDatabaseName(0, databaseName);
        this.hsqlServer.setDatabasePath(0, databasePath);
        this.hsqlServer.start();
        Logger.getGlobal().log(Level.INFO, this.hsqlServer.getDatabasePath(0, true));
    }

    @Override
    public void contextDestroyed(final ServletContextEvent sce) {
        this.hsqlServer.stop();
        Logger.getGlobal().log(Level.INFO, "Application context has been destroyed");
    }

}
