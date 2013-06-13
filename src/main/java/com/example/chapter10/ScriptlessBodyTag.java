package com.example.chapter10;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ScriptlessBodyTag extends SimpleTagSupport {

	@Override
	public void doTag() throws IOException, JspException {
		getJspContext().getOut().println("This JSP Body Tag just prints body in bold and nothing more <b>");
		getJspBody().invoke(null);
		getJspContext().getOut().println("</b>");
	}

}
