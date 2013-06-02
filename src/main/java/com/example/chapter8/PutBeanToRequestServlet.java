package com.example.chapter8;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PutBeanToRequestServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,
			IOException {
		final Employee employee = new Employee();
		employee.setFirstName("First Name From Servlet");
		employee.setLastName("Last Name From Servlet");
		employee.setId(13);
		request.setAttribute("employee", employee);
		final RequestDispatcher view = request.getRequestDispatcher("displayPassedValueUseBean.jsp");
		view.forward(request, response);
	}

}
