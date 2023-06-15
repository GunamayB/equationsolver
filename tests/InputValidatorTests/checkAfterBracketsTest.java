package tests.InputValidatorTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import input.InputValidator;

class checkAfterBracketsTest{

	@Test
	void test1() {
		InputValidator inputValidator = InputValidator.getInstance();
		String [] input= {"(","^","1"};
		boolean result = inputValidator.checkAfterBrackets(input);
		assertEquals(false, result);
	}
	
	@Test
	void test2() {
		InputValidator inputValidator = InputValidator.getInstance();
		String [] input= {"(","x","+","1",")","^","2"};
		boolean result = inputValidator.checkAfterBrackets(input);
		assertEquals(false, result);
	}
	
	@Test
	void test3() {
		InputValidator inputValidator = InputValidator.getInstance();
		String [] input= {};
		boolean result = inputValidator.checkAfterBrackets(input);
		assertEquals(true, result);
	}
	
	@Test
	void test4() {
		InputValidator inputValidator = InputValidator.getInstance();
		String [] input= {"(","x","+","1",")","-","2"};
		boolean result = inputValidator.checkAfterBrackets(input);
		assertEquals(true, result);
	}
}

