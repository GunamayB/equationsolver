package tests.InputValidatorTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import input.InputValidator;

public class isValidTest {
	@Test
	void test1() {
		InputValidator inputValidator = new InputValidator();
		String input= "x $";
		boolean result = inputValidator.isValid(input);
		assertEquals(false, result);
	}
	
	@Test
	void test2() {
		InputValidator inputValidator = new InputValidator();
		String input= "(x";
		boolean result = inputValidator.isValid(input);
		assertEquals(false, result);
	}
	@Test
	void test3() {
		InputValidator inputValidator = new InputValidator();
		String input= "x+2+";
		boolean result = inputValidator.isValid(input);
		assertEquals(false, result);
	}
	@Test
	void test4() {
		InputValidator inputValidator = new InputValidator();
		String input= ".x";
		boolean result = inputValidator.isValid(input);
		assertEquals(false, result);
	}
	@Test
	void test5() {
		InputValidator inputValidator = new InputValidator();
		String input= "(x+2)^2";
		boolean result = inputValidator.isValid(input);
		assertEquals(false, result);
	}
	@Test
	void test6() {
		InputValidator inputValidator = new InputValidator();
		String input= "x5";
		boolean result = inputValidator.isValid(input);
		assertEquals(false, result);
	}
	@Test
	void test7() {
		InputValidator inputValidator = new InputValidator();
		String input= "5^6x";
		boolean result = inputValidator.isValid(input);
		assertEquals(false, result);
	}

	@Test
	void test8() {
		InputValidator inputValidator = new InputValidator();
		String input= "x^y";
		boolean result = inputValidator.isValid(input);
		assertEquals(false, result);
	}
	@Test
	void test9() {
		InputValidator inputValidator = new InputValidator();
		String input= "x";
		boolean result = inputValidator.isValid(input);
		assertEquals(true, result);
	}
	@Test
	void test10() {
		InputValidator inputValidator = new InputValidator();
		String input= "5";
		boolean result = inputValidator.isValid(input);
		assertEquals(false, result);
	}
}
