package com.example.chapter13.compression;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class CompressionResponseWrapper extends HttpServletResponseWrapper {

	private GZIPServletOutputStream servletGzipOS;

	private PrintWriter pw = null;

	private Object streamUsed = null;

	public CompressionResponseWrapper(final HttpServletResponse response) {
		super(response);
	}

	@Override
	public void setContentLength(final int length) {
	}

	public GZIPOutputStream getGZIPOutputStream() {
		return servletGzipOS.internalGzipOS;
	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		if ((streamUsed != null) && (streamUsed != pw)) {
			throw new IllegalStateException("The getWriter() method has been already accessed");
		}
		if (servletGzipOS == null) {
			servletGzipOS = new GZIPServletOutputStream(getResponse().getOutputStream());
			streamUsed = servletGzipOS;
		}
		return servletGzipOS;
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		if ((streamUsed != null) && (streamUsed != servletGzipOS)) {
			throw new IllegalStateException("The getOutputStream() method has been already accessed");
		}

		if (pw == null) {
			servletGzipOS = new GZIPServletOutputStream(getResponse().getOutputStream());
			final OutputStreamWriter osw = new OutputStreamWriter(servletGzipOS, getResponse().getCharacterEncoding());
			pw = new PrintWriter(osw);
		}
		return pw;
	}
}
