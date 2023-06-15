package tests.quadraticEquationTest;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import equation.ConstantTerm;
import equation.LinearEquation;
import equation.QuadraticEquation;
import equation.Term;
import equation.VariableTerm;
import solution.Solution;

public class quadraticSolveTest {

	@Test
	public void test1() {
		ArrayList<Term> terms = new ArrayList<>();
		terms.add(new VariableTerm("x^2"));
		terms.add(new VariableTerm("4x"));
		terms.add(new ConstantTerm("4"));
		 QuadraticEquation eq = new QuadraticEquation(terms);
		 ArrayList<Solution>solutions= eq.solve();
		 ArrayList<String>result= new ArrayList<String>();
		 for(Solution s:solutions) {
			 result.add(s.toString());
		 }
		 String [] expected = {"x=-2.00"};
		assertArrayEquals(expected, result.toArray());
	}
	@Test
	public void test2() {
		ArrayList<Term> terms = new ArrayList<>();
		terms.add(new VariableTerm("x^2"));
		terms.add(new ConstantTerm("-4"));
		 QuadraticEquation eq = new QuadraticEquation(terms);
		 ArrayList<Solution>solutions= eq.solve();
		 ArrayList<String>result= new ArrayList<String>();
		 for(Solution s:solutions) {
			 result.add(s.toString());
		 }
		 String [] expected = {"x=2.00","x=-2.00"};
		assertArrayEquals(expected, result.toArray());
	}
	@Test
	public void test3() {
		ArrayList<Term> terms = new ArrayList<>();
		terms.add(new VariableTerm("x^2"));
		terms.add(new ConstantTerm("1"));
		 QuadraticEquation eq = new QuadraticEquation(terms);
		 ArrayList<Solution>solutions= eq.solve();
		 ArrayList<String>result= new ArrayList<String>();
		 for(Solution s:solutions) {
			 result.add(s.toString());
		 }
		 String [] expected = {"No real roots"};
		assertArrayEquals(expected, result.toArray());
	}
}
