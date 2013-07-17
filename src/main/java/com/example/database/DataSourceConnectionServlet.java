package com.example.database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/database/DataSourceConnection.do")
public class DataSourceConnectionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static Logger LOG = Logger.getLogger(DataSourceConnectionServlet.class.getName());

	private Connection connection;

	@Override
	public void init() {
		try {
			final Context context = new InitialContext();
			final DataSource ds = (DataSource) context.lookup("java:/comp/env/"
					+ getServletContext().getInitParameter("dbJNDIName"));
			connection = ds.getConnection("sa", "");
		} catch (final NamingException exc) {
			LOG.severe("Error on initializing initial context: " + exc.getMessage());
		} catch (final SQLException sqlEx) {
			LOG.severe("Can't obtain connection: " + sqlEx.getLocalizedMessage());
		}
	}

	@Override
	protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException,
			IOException {
		resp.setContentType("text/html");
		final PrintWriter writer = resp.getWriter();
		writer.println("<html><body>");
		writer.println("Datasource Connection state: " + connection);
		writer.println("</body></html>");
	}

}
