package com.example.database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/database/JDBCConnection.do", loadOnStartup = 1, initParams = { @WebInitParam(name = "jdbcConnectionName", value = "jdbc:hsqldb:hsql://localhost/") })
public class JDBCConnectionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static Logger LOG = Logger.getLogger(JDBCConnectionServlet.class.getName());
	static {
		LOG.setUseParentHandlers(true);
	}

	private Connection connection;

	@Override
	public void init() {
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			final String databaseUrl = getInitParameter("jdbcConnectionName")
					+ getServletContext().getInitParameter("databaseName");
			connection = DriverManager.getConnection(databaseUrl, "sa", "");
		} catch (final SQLException sqlEx) {
			LOG.severe("Connection to database doesn't established " + sqlEx.getMessage());
			throw new RuntimeException(sqlEx);
		} catch (final ClassNotFoundException cnfEx) {
			LOG.severe("Can't find driver for HSQL " + cnfEx.getMessage());
			throw new RuntimeException(cnfEx);
		}
		LOG.info("Connection with Driver Manager is established");
	}

	@Override
	public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		final PrintWriter writer = response.getWriter();
		writer.println("<html><body>");
		writer.println("Connection state: " + connection);
		writer.println("</body></html>");
	}

}
