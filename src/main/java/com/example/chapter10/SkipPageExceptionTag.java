package com.example.chapter10;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SkipPageExceptionTag extends SimpleTagSupport {

	private String uselessAttribute;

	private boolean throwException;

	@Override
	public void doTag() throws IOException, JspException {
		if (uselessAttribute != null && !uselessAttribute.isEmpty()) {
			getJspContext().getOut().println("Apply useless attribute: <b>" + uselessAttribute + "</b>");
		}
		getJspBody().invoke(null);
		if (throwException) {
			throw new SkipPageException("I wan't see anything after this exception on the JSP page");
		}

	}

	public void setUselessAttribute(final String uselessAttribute) {
		this.uselessAttribute = uselessAttribute;
	}

	public void setThrowException(final boolean throwException) {
		this.throwException = throwException;
	}

}
