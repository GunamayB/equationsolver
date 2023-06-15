package tests.InputValidatorTests;

import org.junit.Test;
import static org.junit.Assert.*;
import input.*;

public class checkEqualsToSignTest{

	@Test
	public void test1() {
		InputValidator inputValidator = InputValidator.getInstance(); 
		String[] input = {"=","+"};
		boolean result=inputValidator.checkEqualsToSign(input);
		assertEquals(false,result);
	}
	
	@Test
	public void test2() {
		InputValidator inputValidator = InputValidator.getInstance(); 
		String[] input = {"+","="};
		boolean result=inputValidator.checkEqualsToSign(input);
		assertEquals(false,result);
	}
	
	@Test
	public void test3() {
		InputValidator inputValidator = InputValidator.getInstance(); 
		String[] input = {"x","+","1","=","=","1"};
		boolean result=inputValidator.checkEqualsToSign(input);
		assertEquals(false,result);
	}
	
	@Test
	public void test4() {
		InputValidator inputValidator = InputValidator.getInstance(); 
		String[] input = {"x","+","1","=","0"};
		boolean result=inputValidator.checkEqualsToSign(input);
		assertEquals(true,result);
	}
}
