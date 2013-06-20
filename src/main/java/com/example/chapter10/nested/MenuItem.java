package com.example.chapter10.nested;

import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MenuItem extends SimpleTagSupport {

	private String menuItem;

	@Override
	public void doTag() {
		final JspTag parent = findAncestorWithClass(this, MenuFirstLevel.class);
		final MenuFirstLevel subMenu = (MenuFirstLevel) parent;
		subMenu.addSubMenuList(menuItem);
	}

	public void setMenuItem(final String menuItem) {
		this.menuItem = menuItem;
	}

}
