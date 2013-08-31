package com.example.annotations;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/miltipart")
@MultipartConfig()
public class MultipartProcessServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,
			IOException {
		final Collection<Part> parts = request.getParts();
		for (final Part part : parts) {
			part.getName();
		}
		request.getRequestDispatcher("/WEB-INF/jsps/multipartOutput.jsp").forward(request, response);
	}
}
