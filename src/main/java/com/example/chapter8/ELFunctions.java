package com.example.chapter8;

import java.util.List;
import java.util.logging.Logger;

public class ELFunctions {

	private static final Logger logger = Logger.getLogger(ELFunctions.class.getName());
	static {
		logger.setUseParentHandlers(true);
	}

	public static int addition(final int operand1, final int operand2) {
		return operand1 + operand2;
	}

	public static int multiplication(final List<Integer> list) {
		int result = 1;
		for (final Integer operand : list) {
			result *= operand;
		}
		return result;
	}

	public static void sideEffect() {
		logger.info("Side effect function");
	}

}
