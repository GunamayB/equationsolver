package tests.postValidatorTests;
import org.junit.Test;
import static org.junit.Assert.*;
import input.*;

public class checkDegreeTest{

	@Test
	public void test1() {
		quadraticPostValidator postValidator = quadraticPostValidator.getInstance(); 
		String input = "x";
		int degree=postValidator.checkDegree(input);
		assertEquals(1,degree);
	}

	
	@Test
	public void test2() {
		quadraticPostValidator postValidator = quadraticPostValidator.getInstance(); 
		String input = "x^2";
		int degree=postValidator.checkDegree(input);
		assertEquals(2,degree);
	}
	
	
	@Test
	public void test3() {
		quadraticPostValidator postValidator = quadraticPostValidator.getInstance(); 
		String input = "x^2+x^3";
		int degree=postValidator.checkDegree(input);
		assertEquals(3,degree);
	}
	
	@Test
	public void test5() {
		quadraticPostValidator postValidator = quadraticPostValidator.getInstance(); 
		String input = "";
		int degree=postValidator.checkDegree(input);
		assertEquals(0,degree);
	}
	
	@Test
	public void test6() {
		quadraticPostValidator postValidator = quadraticPostValidator.getInstance(); 
		String input = "9742";
		int degree=postValidator.checkDegree(input);
		assertEquals(0,degree);
	}
	
	@Test
	public void test7() {
		quadraticPostValidator postValidator = quadraticPostValidator.getInstance(); 
		String input = "x^22+x^3";
		int degree=postValidator.checkDegree(input);
		assertEquals(22,degree);
	}
	
	@Test
	public void test8() {
		quadraticPostValidator postValidator = quadraticPostValidator.getInstance(); 
		String input = "x^29+x^35";
		int degree=postValidator.checkDegree(input);
		assertEquals(35,degree);
	}
	
	
}
