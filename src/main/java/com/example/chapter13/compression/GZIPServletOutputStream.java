package com.example.chapter13.compression;

import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletOutputStream;

public class GZIPServletOutputStream extends ServletOutputStream {

	GZIPOutputStream internalGzipOS;

	public GZIPServletOutputStream(final ServletOutputStream servletOutputStream) throws IOException {
		internalGzipOS = new GZIPOutputStream(servletOutputStream);

	}

	@Override
	public void write(final int b) throws IOException {
		internalGzipOS.write(b);
	}

}
