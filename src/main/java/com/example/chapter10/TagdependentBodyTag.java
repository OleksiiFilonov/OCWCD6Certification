package com.example.chapter10;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TagdependentBodyTag extends SimpleTagSupport {

	@Override
	public void doTag() throws IOException, JspException {
		getJspContext().getOut().println("Just print tagdependent body<br/>");
		getJspBody().invoke(null);
	}

}
