package com.example.chapter10;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class EmptyBodyTag extends SimpleTagSupport {

	private String testAttribute;

	@Override
	public void doTag() throws JspException, IOException {
		getJspContext().getOut().println(
				"This tag doesn't have any body, only one attribute: <b>" + testAttribute + "</b>");
	}

	public void setTestAttribute(final String testAttribute) {
		this.testAttribute = testAttribute;
	}
}
