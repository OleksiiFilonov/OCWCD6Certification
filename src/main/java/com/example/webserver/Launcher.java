package com.example.webserver;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class Launcher {
	
	public static void main(String[] args) throws Exception {
		Server server = new Server(8080);
		WebAppContext webApp = new WebAppContext();
		webApp.setContextPath("/chapter2");
		webApp.setResourceBase("/DATA/Certification/Workspace/chapter2/target/chapter2");
		server.setHandler(webApp);
		server.start();
		server.join();
	}

}
