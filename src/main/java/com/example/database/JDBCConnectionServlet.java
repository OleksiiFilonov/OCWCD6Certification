package com.example.database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            this.connection = DriverManager.getConnection(getInitParameter("jdbcConnectionName")
                    + getServletContext().getInitParameter("databaseName"), "sa", "");
        } catch(final SQLException sqlEx) {
            LOG.severe("Connection to database doesn't established " + sqlEx.getMessage());
            throw new RuntimeException(sqlEx);
        } catch(final ClassNotFoundException cnfEx) {
            LOG.severe("Can't find driver for HSQL " + cnfEx.getMessage());
            throw new RuntimeException(cnfEx);
        }
        LOG.info("Connection Loaded");
    }

    @Override
    public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        final PrintWriter writer = response.getWriter();
        writer.println("<html><body>");
        writer.println("Connection state: " + this.connection);
        writer.println("</body></html>");
    }

}
