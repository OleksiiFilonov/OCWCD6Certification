package com.example.chapter10.nested;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class MenuFirstLevel extends TagSupport {

	private static final long serialVersionUID = 1L;

	private List<String> subMenuList;

	public void addSubMenuList(final String item) {
		subMenuList.add(item);
	}

	@Override
	public int doStartTag() {
		subMenuList = new ArrayList<String>();
		return EVAL_BODY_INCLUDE;
	}

	@Override
	public int doEndTag() {
		Tag parent = getParent();
		while (!(parent instanceof MenuSecondLevel)) {
			parent = getParent();
		}

		if (parent != null) {
			final MenuSecondLevel menuSecondLevel = (MenuSecondLevel) parent;
			menuSecondLevel.addMenuList(subMenuList);
		}

		return EVAL_PAGE;
	}
}
