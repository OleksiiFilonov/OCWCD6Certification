package com.example.chapter10;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.tagext.TagSupport;

public class ClassicalTagSupportTableIterationHandler extends TagSupport {

	private static final String TABLE_BEGIN = "<table border=\"%d\">";

	private static final long serialVersionUID = 1L;

	private static final String TD_PATTERN = "<td>%s</td>";

	private String element;

	private List<String> options;

	private int border;

	private Object elementTemp;

	private int index = 0;

	private boolean exc = false;

	@Override
	public int doStartTag() {
		elementTemp = pageContext.getAttribute(element);
		index = 0;
		exc = false;
		try {
			pageContext.getOut().println(String.format(TABLE_BEGIN, border));
			printTDTag();
			return EVAL_BODY_INCLUDE;
		} catch (final IOException ioEx) {
			printIOException(ioEx);
			return SKIP_BODY;
		}
	}

	private void printTDTag() {
		pageContext.setAttribute(element, String.format(TD_PATTERN, options.get(index++)));
	}

	@Override
	public int doAfterBody() {
		if (index < options.size()) {
			printTDTag();
			return EVAL_BODY_AGAIN;
		}
		return SKIP_BODY;
	}

	@Override
	public int doEndTag() {
		pageContext.setAttribute(element, elementTemp);
		try {
			pageContext.getOut().println("</table>");
		} catch (final IOException ioEx) {
			printIOException(ioEx);
		}
		if (exc) {
			return SKIP_PAGE;
		} else {
			return EVAL_PAGE;
		}
	}

	public void setOptions(final List<String> options) {
		this.options = options;
	}

	public void setElement(final String element) {
		this.element = element;
	}

	private void printIOException(final IOException ioEx) {
		System.out.println("exception has been thrown " + ioEx.getMessage());
		exc = true;
	}

	public void setBorder(final int border) {
		this.border = border;
	}

}
