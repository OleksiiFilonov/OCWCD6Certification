package com.example.chapter10;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ScriptlessIterateBodyTag extends SimpleTagSupport {

	private String[] collection;

	private String elementName;

	@Override
	public void doTag() throws IOException, JspException {
		getJspContext().getOut().println("Iterate over body<br/>");
		for (final Object element : collection) {
			getJspContext().setAttribute(elementName, element);
			getJspBody().invoke(null);
			getJspContext().getOut().println("<br/>");
		}
	}

	public void setCollection(final String[] collection) {
		this.collection = collection;
	}

	public void setElementName(final String elementName) {
		this.elementName = elementName;
	}

}
