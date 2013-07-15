package com.example.chapter5;

import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hsqldb.jdbc.JDBCDataSource;
import org.hsqldb.server.Server;

public class ExampleServletContextListener implements ServletContextListener {

	private static final Logger LOG = Logger.getLogger(ExampleServletContextListener.class.getName());

	private Server hsqlServer;

	@Override
	public void contextInitialized(final ServletContextEvent scevent) {
		final ServletContext context = scevent.getServletContext();
		final String paramName = "dbJNDIName";
		final ContextAttributeObject attribute = new ContextAttributeObject(paramName,
				context.getInitParameter(paramName));
		context.setAttribute("dbJNDIObject", attribute);
		final String databaseName = context.getInitParameter("databaseName");
		final String databasePath = context.getInitParameter("databasePath");
		startHQSLLocalDatabase(databaseName, databasePath);
		final String dbJNDIName = context.getInitParameter("dbJNDIName");
		/*
		 * try { bindDataSource(databaseName, dbJNDIName); } catch (final
		 * NamingException exc) {
		 * LOG.severe("Can't add DatasourceConnection to JNDI context: " +
		 * exc.getMessage()); }
		 */
	}

	private void bindDataSource(final String databaseName, final String dbJNDIName) throws NamingException {
		final JDBCDataSource ds = new JDBCDataSource();
		final String connectionUrl = "jdbc:hsqldb:hsql://localhost/" + databaseName;
		ds.setDatabase(connectionUrl);
		final Context ctx = new InitialContext();
		ctx.bind(dbJNDIName, ds);
	}

	private void startHQSLLocalDatabase(final String databaseName, final String databasePath) {
		hsqlServer = new Server();
		hsqlServer.setDatabaseName(0, databaseName);
		hsqlServer.setDatabasePath(0, databasePath);
		hsqlServer.start();
		LOG.info(hsqlServer.getDatabasePath(0, true));
	}

	@Override
	public void contextDestroyed(final ServletContextEvent sce) {
		hsqlServer.stop();
		LOG.info("Application context has been destroyed");
	}

}
