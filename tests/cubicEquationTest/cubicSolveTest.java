package tests.cubicEquationTest;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import equation.ConstantTerm;
import equation.CubicEquation;
import equation.LinearEquation;
import equation.QuadraticEquation;
import equation.Term;
import equation.VariableTerm;
import solution.Solution;

public class cubicSolveTest {

	@Test
	public void test1() {
		ArrayList<Term> terms = new ArrayList<>();
		terms.add(new VariableTerm("x^3"));
		terms.add(new VariableTerm("-6x^2"));
		terms.add(new VariableTerm("11x"));
		terms.add(new ConstantTerm("-6"));
		 CubicEquation eq = new CubicEquation(terms);
		 ArrayList<Solution>solutions= eq.solve();
		 ArrayList<String>result= new ArrayList<String>();
		 for(Solution s:solutions) {
			 result.add(s.toString());
		 }
		 String [] expected = {"x=1.00","x=3.00","x=2.00"};
		assertArrayEquals(expected, result.toArray());
	}
	@Test
	public void test2() {
		ArrayList<Term> terms = new ArrayList<>();
		terms.add(new VariableTerm("x^3"));
		terms.add(new ConstantTerm("-27"));
		CubicEquation eq = new CubicEquation(terms);
		 ArrayList<Solution>solutions= eq.solve();
		 ArrayList<String>result= new ArrayList<String>();
		 for(Solution s:solutions) {
			 result.add(s.toString());
		 }
		 String [] expected = {"x=3.00"};
		assertArrayEquals(expected, result.toArray());
	}
//	@Test
//	public void test3() {
//		ArrayList<Term> terms = new ArrayList<>();
//		terms.add(new VariableTerm("x^3"));
//		terms.add(new ConstantTerm("1"));
//		CubicEquation eq = new CubicEquation(terms);
//		 ArrayList<Solution>solutions= eq.solve();
//		 ArrayList<String>result= new ArrayList<String>();
//		 for(Solution s:solutions) {
//			 result.add(s.toString());
//		 }
//		 String [] expected = {"No real roots"};
//		assertArrayEquals(expected, result.toArray());
//	}
}
