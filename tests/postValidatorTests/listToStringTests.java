package tests.postValidatorTests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import equation.ConstantTerm;
import equation.Term;
import equation.VariableTerm;
import input.quadraticPostValidator;

public class listToStringTests {
	
	@Test
	public void test1() {
		ArrayList<Term> terms= new ArrayList<>(); 
		terms.add(new VariableTerm("x"));
		terms.add(new VariableTerm("-2y"));
		terms.add(new ConstantTerm("5"));
		String result=quadraticPostValidator.getInstance().arrayToString(terms);
		assertEquals("1.0x-2.0y+5.0", result);
	}
	@Test
	public void test2() {
		ArrayList<Term> terms= new ArrayList<>(); 
		terms.add(new VariableTerm("+x^5"));
		terms.add(new VariableTerm("-2y"));
		terms.add(new ConstantTerm("+5"));
		String result=quadraticPostValidator.getInstance().arrayToString(terms);
		assertEquals("1.0x^5-2.0y+5.0", result);
	}
}
