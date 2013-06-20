package com.example.chapter10.nested;

import static java.lang.System.out;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MenuSecondLevel extends TagSupport {

	private static final long serialVersionUID = 1L;

	private List<List<String>> menuList;

	public void addMenuList(final List<String> subMenuList) {
		menuList.add(subMenuList);
	}

	@Override
	public int doStartTag() {
		menuList = new ArrayList<List<String>>();
		return EVAL_BODY_INCLUDE;
	}

	@Override
	public int doEndTag() {
		final JspWriter jspOut = pageContext.getOut();
		try {
			jspOut.println("<div>");
			for (final List<String> subMenu : menuList) {
				out.println("Iterate over top level menu");
				jspOut.println("<ul>");
				for (final String menuItem : subMenu) {
					out.println("Iterate over sub level menu");
					jspOut.println("<li>" + menuItem + "</li>");
				}
				jspOut.println("</ul>");
			}
			jspOut.println("</div>");
		} catch (final IOException exc) {
			out.println("SubMenuExc " + exc.getMessage());
		}
		return EVAL_PAGE;
	}

}
