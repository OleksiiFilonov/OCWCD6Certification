package com.example.chapter11;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayUploadedFileServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		final BufferedInputStream in = new BufferedInputStream(request.getInputStream());
		final BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
		final byte[] buffer = new byte[1024];
		int length = 0;
		while ((length = in.read(buffer)) >= 0) {
			out.write(buffer, 0, length);
		}
		/*
		 * final BufferedReader in = new BufferedReader(new
		 * InputStreamReader(request.getInputStream())); final PrintWriter out =
		 * response.getWriter(); String line = null; while ((line =
		 * in.readLine()) != null) { out.println(line); }
		 */
		in.close();
		out.close();
	}

}
