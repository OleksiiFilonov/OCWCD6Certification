package com.example.annotations.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.ServletSecurity.TransportGuarantee;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/annotations/security/allowadminaccess", "/annotations/security/allowsuperadminaccess" })
@ServletSecurity(@HttpConstraint(rolesAllowed = "admin", transportGuarantee = TransportGuarantee.CONFIDENTIAL))
public class OnlyAdminAccessSecurityAnnotationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,
			IOException {
		response.getWriter().println(
				"GET from OnlyAdminAccessSecurityAnnotationServlet for " + request.getUserPrincipal().getName());
	}

}
