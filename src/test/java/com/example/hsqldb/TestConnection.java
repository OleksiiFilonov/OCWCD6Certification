package com.example.hsqldb;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hsqldb.server.Server;
import org.junit.Test;

public class TestConnection {

    @Test
    public void testHsqlConnection() throws ClassNotFoundException, SQLException {
        // 'Server' is a class of HSQLDB representing
        // the database server
        Server hsqlServer = null;
        try {
            hsqlServer = new Server();

            // HSQLDB prints out a lot of informations when
            // starting and closing, which we don't need now.
            // Normally you should point the setLogWriter
            // to some Writer object that could store the logs.
            final PrintWriter console = new PrintWriter(new PrintStream(System.out));
            hsqlServer.setLogWriter(console);

            // The actual database will be named 'xdb' and its
            // settings and data will be stored in files
            // testdb.properties and testdb.script
            hsqlServer.setDatabaseName(0, "xdb");
            hsqlServer.setDatabasePath(0, "mem:mymemdb");

            // Start the database!
            hsqlServer.start();

            Connection connection = null;
            // We have here two 'try' blocks and two 'finally'
            // blocks because we have two things to close
            // after all - HSQLDB server and connection
            try {
                // Default user of the HSQLDB is 'sa'
                // with an empty password
                connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb", "sa", "");

                // Here we run a few SQL statements to see if
                // everything is working.
                // We first drop an existing 'testtable' (supposing
                // it was there from the previous run), create it
                // once again, insert some data and then read it
                // with SELECT query.
                // connection.prepareStatement("drop table testtable;").execute();
                connection.prepareStatement("create table testtable ( id INTEGER, " + "name VARCHAR(255));").execute();
                connection.prepareStatement("insert into testtable(id, name) " + "values (1, 'testvalue');").execute();
                final ResultSet rs = connection.prepareStatement("select * from testtable;").executeQuery();

                // Checking if the data is correct
                rs.next();
                System.out.println("Id: " + rs.getInt(1) + " Name: " + rs.getString(2));
            } finally {
                // Closing the connection
                if(connection != null) {
                    connection.close();
                }

            }
        } finally {
            // Closing the server
            if(hsqlServer != null) {
                hsqlServer.stop();
            }
        }
    }
}
