package tests.InputValidatorTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import input.InputValidator;

class checkVariableTest{

	@Test
	void test1() {
		InputValidator inputValidator = InputValidator.getInstance();
		String [] input= {"3"};
		boolean result = inputValidator.checkVariable(input);
		assertEquals(false, result);
	}
	@Test
	void test2() {
		InputValidator inputValidator = InputValidator.getInstance();
		String [] input= {"3","x"};
		boolean result = inputValidator.checkVariable(input);
		assertEquals(true, result);
	}

}

