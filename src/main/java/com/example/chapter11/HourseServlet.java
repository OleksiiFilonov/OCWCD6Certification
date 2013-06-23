package com.example.chapter11;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HourseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
		final BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
		final BufferedInputStream in = new BufferedInputStream(getServletContext().getResourceAsStream(
				"/chapter11/hourse.jpg"));
		final byte[] buffer = new byte[1024];
		int length = 0;
		while ((length = in.read(buffer)) >= 0) {
			out.write(buffer, 0, length);
		}
		out.close();
		in.close();
	}

}
