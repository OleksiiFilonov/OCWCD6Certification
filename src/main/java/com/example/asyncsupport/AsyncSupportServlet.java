package com.example.asyncsupport;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AsyncSupportServlet", asyncSupported = true, value = "/asyncServlet", initParams = { @WebInitParam(name = "timeout", value = "20000") })
public class AsyncSupportServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void service(final HttpServletRequest req, final HttpServletResponse res) throws ServletException {
		final AsyncContext asyncContext = req.startAsync();
		final Integer asyncTimeout = Integer.valueOf(getServletConfig().getInitParameter("timeout"));
		asyncContext.setTimeout(asyncTimeout);
		final AsyncListener listener = asyncContext.createListener(AsyncListenerLogger.class);
		asyncContext.addListener(listener);
		asyncContext.start(new AsyncProcessingTask(asyncContext));
	}
}
