package tests.equationTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import equation.ConstantTerm;
import equation.LinearEquation;
import equation.Term;
import equation.VariableTerm;

public class superclassTests {
	@Test
	public void testToString() {
		ArrayList<Term> terms = new ArrayList<>();
		terms.add(new VariableTerm("x"));
		terms.add(new VariableTerm("-2y"));
		terms.add(new ConstantTerm("5"));
		 LinearEquation eq = new LinearEquation(terms);
		assertEquals("1.0x-2.0y+5.0", eq.toString());
	}
	@Test
	public void testGetConst1() {
		ArrayList<Term> terms = new ArrayList<>();
		terms.add(new VariableTerm("x"));
		terms.add(new VariableTerm("-2y"));
		terms.add(new ConstantTerm("5"));
		 LinearEquation eq = new LinearEquation(terms);
		assertEquals("5.0", eq.getConstant().toString());
	}
	@Test
	public void testGetConst2() {
		ArrayList<Term> terms = new ArrayList<>();
		terms.add(new VariableTerm("x"));
		terms.add(new VariableTerm("-2y"));
		 LinearEquation eq = new LinearEquation(terms);
		assertEquals("0.0", eq.getConstant().toString());
	}
}
