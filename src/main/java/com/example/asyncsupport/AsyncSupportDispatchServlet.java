package com.example.asyncsupport;

import javax.servlet.AsyncContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(value = "/asyncServletDispatch", asyncSupported = true)
public class AsyncSupportDispatchServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(final javax.servlet.http.HttpServletRequest req,
			final javax.servlet.http.HttpServletResponse resp) {
		final AsyncContext asyncContext = req.startAsync();
		asyncContext.addListener(new AsyncListenerLogger());
		asyncContext.dispatch("/asyncServlet");
	};

}
