package tests.InputValidatorTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import input.InputValidator;

class checkAfterVariableTest{

	@Test
	void test1() {
		InputValidator inputValidator = InputValidator.getInstance();
		String [] input= {"x","9"};
		boolean result = inputValidator.checkAfterVariable(input);
		assertEquals(false, result);
	}
	
	@Test
	void test2() {
		InputValidator inputValidator = InputValidator.getInstance();
		String [] input= {"9","x"};
		boolean result = inputValidator.checkAfterVariable(input);
		assertEquals(true, result);
	}
	
	@Test
	void test3() {
		InputValidator inputValidator = InputValidator.getInstance();
		String [] input= {"x","+"};
		boolean result = inputValidator.checkAfterVariable(input);
		assertEquals(true, result);
	}
}
