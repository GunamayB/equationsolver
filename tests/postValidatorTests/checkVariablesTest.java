package tests.postValidatorTests;
import org.junit.Test;
import static org.junit.Assert.*;
import input.*;

public class checkVariablesTest{

	@Test
	public void test1() {
		quadraticPostValidator postValidator = quadraticPostValidator.getInstance(); 
		String input = "x+y-5";
		boolean result=postValidator.checkVariables(input);
		assertEquals(true,result);
	}
	
	@Test
	public void test2() {
		quadraticPostValidator postValidator = quadraticPostValidator.getInstance(); 
		String input = "x^2+y-5";
		boolean result=postValidator.checkVariables(input);
		assertEquals(false,result);
	}
	
	@Test
	public void test3() {
		quadraticPostValidator postValidator = quadraticPostValidator.getInstance(); 
		String input = "x^3+z^2+z+y-5";
		boolean result=postValidator.checkVariables(input);
		assertEquals(false,result);
	}
}
