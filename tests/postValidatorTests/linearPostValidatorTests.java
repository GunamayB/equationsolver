package tests.postValidatorTests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import equation.ConstantTerm;
import equation.Term;
import equation.VariableTerm;
import input.cubicPostValidator;
import input.linearPostValidator;
import input.quadraticPostValidator;

public class linearPostValidatorTests {
	@Test
	public void test1() {
		ArrayList<Term> terms= new ArrayList<>(); 
		terms.add(new VariableTerm("x^2"));
		terms.add(new VariableTerm("-2y"));
		terms.add(new ConstantTerm("5"));
		Boolean result=linearPostValidator.getInstance().isValid(terms);
		assertEquals(false, result);
	}
	@Test
	public void test2() {
		ArrayList<Term> terms= new ArrayList<>(); 
		terms.add(new VariableTerm("x"));
		terms.add(new VariableTerm("-2y"));
		terms.add(new ConstantTerm("5"));
		Boolean result=linearPostValidator.getInstance().isValid(terms);
		assertEquals(true, result);
	}
	
	
}
