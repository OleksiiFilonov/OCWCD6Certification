package com.example.chapter2.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import com.example.chapter2.model.BeerExpert;

import java.io.*;

public class BeerSelect extends HttpServlet {
	
	private BeerExpert beerExpert = new BeerExpert(); 

	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String colorParam = request.getParameter("color");
		request.setAttribute("styles", beerExpert.getBrands(colorParam));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
		dispatcher.forward(request, response);
	}

}
