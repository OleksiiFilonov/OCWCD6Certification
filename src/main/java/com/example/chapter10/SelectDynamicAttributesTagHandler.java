package com.example.chapter10;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SelectDynamicAttributesTagHandler extends SimpleTagSupport implements DynamicAttributes {

	private static final String ATTR_PATTER = " %s='%s' ";
	private static final String OPTION_PATTERN = "<option value='%s'>%s</option>";

	private final Map<String, Object> dynamicAttributes = new HashMap<String, Object>();

	private String[] optionsList;

	private String name;

	private int size;

	@Override
	public void doTag() throws IOException {
		final JspWriter out = getJspContext().getOut();
		out.print("<select ");
		out.print(String.format(ATTR_PATTER, "name", name));
		out.print(String.format(ATTR_PATTER, "size", size));
		for (final Entry<String, Object> dynamicAttribute : dynamicAttributes.entrySet()) {
			out.print(String.format(ATTR_PATTER, dynamicAttribute.getKey(), dynamicAttribute.getValue()));
		}
		out.println(">");
		for (final String option : optionsList) {
			out.println(String.format(OPTION_PATTERN, option, option));
		}

		out.println("</select>");
	}

	@Override
	public void setDynamicAttribute(final String uri, final String name, final Object value) {
		dynamicAttributes.put(name, value);
	}

	public void setOptionsList(final String[] optionsList) {
		this.optionsList = optionsList;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public void setSize(final int size) {
		this.size = size;
	}

}
