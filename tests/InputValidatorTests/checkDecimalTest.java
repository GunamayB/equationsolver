package tests.InputValidatorTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import input.InputValidator;

class checkDecimalTest {

	@Test
	void test1() {
		InputValidator inputValidator = InputValidator.getInstance();
		String [] input= {".","x"};
		boolean result = inputValidator.checkDecimal(input);
		assertEquals(false, result);
	}
	
	@Test
	void test2() {
		InputValidator inputValidator = InputValidator.getInstance();
		String [] input= {".","1","+","x"};
		boolean result = inputValidator.checkDecimal(input);
		assertEquals(true, result);
	}
	
	@Test
	void test3() {
		InputValidator inputValidator = InputValidator.getInstance();
		String [] input= {};
		boolean result = inputValidator.checkDecimal(input);
		assertEquals(true, result);
	}
	
	
	@Test
	void test4() {
		InputValidator inputValidator = InputValidator.getInstance();
		String [] input= {"."};
		boolean result = inputValidator.checkDecimal(input);
		assertEquals(true, result);
	}
	
	@Test
	void test5() {
		InputValidator inputValidator = InputValidator.getInstance();
		String [] input= {".","+"};
		boolean result = inputValidator.checkDecimal(input);
		assertEquals(false, result);
	}
}
 
// didnt take into account the case where there is a sing (+-/*^) right after the .