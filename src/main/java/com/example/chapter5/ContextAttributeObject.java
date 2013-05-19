package com.example.chapter5;

public class ContextAttributeObject {
	
	private final String paramName;
	
	private final String paramValue;

	public ContextAttributeObject(String paramName, String paramValue) {
		this.paramName = paramName;
		this.paramValue = paramValue;
	}

	public String getParamName() {
		return paramName;
	}

	public String getParamValue() {
		return paramValue;
	}

}
