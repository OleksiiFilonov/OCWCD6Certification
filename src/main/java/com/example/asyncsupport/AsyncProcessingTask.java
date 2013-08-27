package com.example.asyncsupport;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.logging.Logger;

import javax.servlet.AsyncContext;

public class AsyncProcessingTask implements Runnable {

	private static final Logger logger = Logger.getLogger(AsyncProcessingTask.class.getName());

	private final AsyncContext context;

	public AsyncProcessingTask(final AsyncContext context) {
		this.context = context;
	}

	@Override
	public void run() {
		try {
			final PrintWriter responseWriter = context.getResponse().getWriter();
			Thread.sleep(5000);
			responseWriter.println(getAsyncHeader());
			Thread.sleep(5000);
			responseWriter.println("<h1>The End</h1>");
		} catch (final IOException | InterruptedException e) {
			logger.warning("Async processing request error " + e.getLocalizedMessage());
		}
		context.complete();
	}

	private String getAsyncHeader() {
		return MessageFormat.format("<h1>Processing Task in async thread_id: [{0}]</h1>", Thread.currentThread()
				.getId());
	}

}
