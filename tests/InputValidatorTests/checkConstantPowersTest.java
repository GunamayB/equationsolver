package tests.InputValidatorTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import input.InputValidator;

class checkConstantPowersTest{

	@Test
	void test1() {
		InputValidator inputValidator = InputValidator.getInstance();
		String [] input= {"9","^","7"};
		boolean result = inputValidator.checkConstantPowers(input);
		assertEquals(false, result);
	}
	
	@Test
	void test2() {
		InputValidator inputValidator = InputValidator.getInstance();
		String [] input= {"9","x","^","7"};
		boolean result = inputValidator.checkConstantPowers(input);
		assertEquals(true, result);
	}
}
