package tests.InputValidatorTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import input.InputValidator;

class OperatorsValidTest {

	@Test
	void test1() {
		InputValidator inputValidator = new InputValidator();
		String [] input= "+2".split("");
		boolean result = inputValidator.operatorsValid(input);
		assertEquals(true, result);
	}
	@Test
	void test2() {
		InputValidator inputValidator = new InputValidator();
		String [] input= "-2".split("");
		boolean result = inputValidator.operatorsValid(input);
		assertEquals(true, result);
	}
	@Test
	void test3() {
		InputValidator inputValidator = new InputValidator();
		String [] input= "*2".split("");
		boolean result = inputValidator.operatorsValid(input);
		assertEquals(false, result);
	}
	@Test
	void test4() {
		InputValidator inputValidator = new InputValidator();
		String [] input= "-6".split("");
		boolean result = inputValidator.operatorsValid(input);
		assertEquals(true, result);
	}
	@Test
	void test5() {
		InputValidator inputValidator = new InputValidator();
		String [] input= "^2".split("");
		boolean result = inputValidator.operatorsValid(input);
		assertEquals(false, result);
	}
	@Test
	void test6() {
		InputValidator inputValidator = new InputValidator();
		String [] input= "2+2-2".split("");
		boolean result = inputValidator.operatorsValid(input);
		assertEquals(true, result);
	}
	@Test
	void test7() {
		InputValidator inputValidator = new InputValidator();
		String [] input= "-2+(5+3)".split("");
		boolean result = inputValidator.operatorsValid(input);
		assertEquals(true, result);
	}
	@Test
	void test8() {
		InputValidator inputValidator = new InputValidator();
		String [] input= "2+*3".split("");
		boolean result = inputValidator.operatorsValid(input);
		assertEquals(false, result);
	}
	@Test
	void test9() {
		InputValidator inputValidator = new InputValidator();
		String [] input= "2+(3*3)".split("");
		boolean result = inputValidator.operatorsValid(input);
		assertEquals(true, result);
	}
	@Test
	void test10() {
		InputValidator inputValidator = new InputValidator();
		String [] input= "2^2+3".split("");
		boolean result = inputValidator.operatorsValid(input);
		assertEquals(true, result);
	}
	@Test
	void test11() {
		InputValidator inputValidator = new InputValidator();
		String [] input= "(*+2)".split("");
		boolean result = inputValidator.operatorsValid(input);
		assertEquals(false, result);
	}
	@Test
	void test12() {
		InputValidator inputValidator = new InputValidator();
		String [] input= "(*+2+*)".split("");
		boolean result = inputValidator.operatorsValid(input);
		assertEquals(false, result);
	}
	@Test
	void test13() {
		InputValidator inputValidator = new InputValidator();
		String [] input= "+2*".split("");
		boolean result = inputValidator.operatorsValid(input);
		assertEquals(false, result);
	}
}
