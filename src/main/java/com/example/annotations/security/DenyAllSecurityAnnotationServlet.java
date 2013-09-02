package com.example.annotations.security;

import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.ServletSecurity.EmptyRoleSemantic;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/annotations/security/denyall")
@ServletSecurity(value = @HttpConstraint(value = EmptyRoleSemantic.DENY))
public class DenyAllSecurityAnnotationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

}
