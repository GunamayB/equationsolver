package tests.InputValidatorTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import input.InputValidator;

class checkPowersTest{

	@Test
	void test1() {
		InputValidator inputValidator = InputValidator.getInstance();
		String [] input= {"2","^","x"};
		boolean result = inputValidator.checkPowers(input);
		assertEquals(false, result);
	}

	@Test
	void test2() {
		InputValidator inputValidator = InputValidator.getInstance();
		String [] input= {"x","^","2"};
		boolean result = inputValidator.checkPowers(input);
		assertEquals(true, result);
	}
}

