package com.example.annotations.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.ServletSecurity.EmptyRoleSemantic;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/annotations/security/allowgetguestgetpostmember")
@ServletSecurity(value = @HttpConstraint(value = EmptyRoleSemantic.DENY), httpMethodConstraints = {
        @HttpMethodConstraint(rolesAllowed = { "guest", "member" }, value = "GET"),
        @HttpMethodConstraint(rolesAllowed = "member", value = "POST") })
public class GetAllowedForGuestGetAndPostAllowedForMembersAnnotationServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
        res.getWriter().println(
                "GET from GetAllowedForGuestGetAndPostAllowedForMembersAnnotationServlet for"
                        + req.getUserPrincipal().getName());
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException,
            IOException {
        resp.getWriter().println(
                "POST from GetAllowedForGuestGetAndPostAllowedForMembersAnnotationServlet for"
                        + req.getUserPrincipal().getName());
    }

}
