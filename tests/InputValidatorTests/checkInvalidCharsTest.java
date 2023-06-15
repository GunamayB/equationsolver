package tests.InputValidatorTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import input.InputValidator;

class checkInvalidCharsTest{

	@Test
	void test1() {
		InputValidator inputValidator = InputValidator.getInstance();
		String [] input= {"(","^","?"};
		boolean result = inputValidator.checkInvalidChars(input);
		assertEquals(false, result);
	}
	
	@Test
	void test2() {
		InputValidator inputValidator = InputValidator.getInstance();
		String [] input= {"(","^","x"};
		boolean result = inputValidator.checkInvalidChars(input);
		assertEquals(true, result);
	}

}

