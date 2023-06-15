package tests.postValidatorTests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import equation.ConstantTerm;
import equation.LinearEquation;
import equation.SimultaneousEquation;
import equation.Term;
import equation.VariableTerm;
import input.linearPostValidator;

public class simultaneousPostValidatorTests {

	@Test
	public void test_1() {

		ArrayList<Term> eq1= new ArrayList<>(); 
		eq1.add(new VariableTerm("x"));
		eq1.add(new VariableTerm("-2y"));
		eq1.add(new ConstantTerm("5"));
		
		ArrayList<Term>eq2= new ArrayList<>();
		eq2.add(new VariableTerm("x"));
		eq2.add(new VariableTerm("-y"));
		eq2.add(new ConstantTerm("-3"));
		

		ArrayList<LinearEquation> equations = new ArrayList<>();
		equations.add(new LinearEquation(eq1));
		equations.add(new LinearEquation(eq2));
		
      boolean result = linearPostValidator.getInstance().isValidSimul(equations);
       
        
        assertEquals(true, result);
		
    }
	@Test
	public void test_2() {

		ArrayList<Term> eq1= new ArrayList<>(); 
		eq1.add(new VariableTerm("x"));
		eq1.add(new VariableTerm("-2y"));
		eq1.add(new ConstantTerm("5"));
		
		ArrayList<Term>eq2= new ArrayList<>();
		eq2.add(new VariableTerm("x"));
		eq2.add(new VariableTerm("-z"));
		eq2.add(new ConstantTerm("-3"));
		

		ArrayList<LinearEquation> equations = new ArrayList<>();
		equations.add(new LinearEquation(eq1));
		equations.add(new LinearEquation(eq2));
		
      boolean result = linearPostValidator.getInstance().isValidSimul(equations);
       
        
        assertEquals(false, result);
		
    }
	
	@Test
	public void test_3() {

		ArrayList<Term> eq1= new ArrayList<>(); 
		eq1.add(new VariableTerm("x"));
		eq1.add(new VariableTerm("-2y"));
		eq1.add(new ConstantTerm("5"));
		
		ArrayList<Term>eq2= new ArrayList<>();
		eq2.add(new VariableTerm("x"));
		eq2.add(new ConstantTerm("-3"));
		

		ArrayList<LinearEquation> equations = new ArrayList<>();
		equations.add(new LinearEquation(eq1));
		equations.add(new LinearEquation(eq2));
		
      boolean result = linearPostValidator.getInstance().isValidSimul(equations);
       
        
        assertEquals(false, result);
		
    }

}
