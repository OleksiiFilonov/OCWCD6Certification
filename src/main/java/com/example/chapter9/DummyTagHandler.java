package com.example.chapter9;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class DummyTagHandler extends SimpleTagSupport {

	private String attribute;

	@Override
	public void doTag() throws JspException, IOException {
		getJspContext().getOut().println("Advice from dummy Tag Handler is " + attribute);
	}

	public void setAttribute(final String attribute) {
		this.attribute = attribute;
	}

}
