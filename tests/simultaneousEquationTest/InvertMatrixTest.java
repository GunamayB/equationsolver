package tests.simultaneousEquationTest;
import static org.junit.Assert.assertArrayEquals;

//test inverse
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import equation.ConstantTerm;
import equation.LinearEquation;
import equation.SimultaneousEquation;
import equation.Term;
import equation.VariableTerm;

public class InvertMatrixTest {
	
	@BeforeEach
	public void setUp() throws Exception {  }
	
	public void tearDown() {}

	@Test
	public void test_1() {

        double[][] expected = {
            {-1, 2}, 
            {-1, 1}, 
        };
		
		ArrayList<Term> eq1= new ArrayList<>();
		eq1.add(new VariableTerm("x"));
		eq1.add(new VariableTerm("-2y"));
		eq1.add(new ConstantTerm("5"));
		
		ArrayList<Term> eq2= new ArrayList<>();
		eq2.add(new VariableTerm("x"));
		eq2.add(new VariableTerm("-y"));
		eq2.add(new ConstantTerm("-3"));
		

		ArrayList<LinearEquation> equations = new ArrayList<>();
		equations.add(new LinearEquation(eq1));
		equations.add(new LinearEquation(eq2));
		
		SimultaneousEquation simul = new SimultaneousEquation(equations);
        simul.setMatrix();

        double[][] result = simul.inverse(simul.getOriginalMatrix());

        assertArrayEquals(result, expected);
		
    }
    
    @Test
	public void test_2() {

        double[][] expected = {
            {5.0/34.0, 0.08823529411764705}, 
            {3.0/34.0, -5.0/34.0}, 
        };
		
		ArrayList<Term> eq1= new ArrayList<>();
		eq1.add(new VariableTerm("5x"));
		eq1.add(new VariableTerm("3y"));
		eq1.add(new ConstantTerm("-7"));
		
		ArrayList<Term>eq2= new ArrayList<>();
		eq2.add(new VariableTerm("3x"));
		eq2.add(new VariableTerm("-5y"));
		eq2.add(new ConstantTerm("23"));
		

		ArrayList<LinearEquation> equations = new ArrayList<>();
		equations.add(new LinearEquation(eq1));
		equations.add(new LinearEquation(eq2));
		
		SimultaneousEquation simul = new SimultaneousEquation(equations);
        simul.setMatrix();

        double[][] result = simul.inverse(simul.getOriginalMatrix());

        assertArrayEquals(result, expected);
		
    }
    
    @Test
	public void test_3() {

        double[][] expected = {
        		{1, -1.9999999999999998}, 
                {-0.49999999999999994, 1.4999999999999998},
      };
		
		ArrayList<Term> eq1= new ArrayList<>();
		eq1.add(new VariableTerm("3x"));
		eq1.add(new VariableTerm("4y"));
		eq1.add(new ConstantTerm("2"));
		
		ArrayList<Term>eq2= new ArrayList<>();
		eq2.add(new VariableTerm("1x"));
		eq2.add(new VariableTerm("2y"));
		eq2.add(new ConstantTerm("5"));
		

		ArrayList<LinearEquation> equations = new ArrayList<>();
		equations.add(new LinearEquation(eq1));
		equations.add(new LinearEquation(eq2));
		
		SimultaneousEquation simul = new SimultaneousEquation(equations);
        simul.setMatrix();

        double[][] result = simul.inverse(simul.getOriginalMatrix());

        assertArrayEquals(result, expected);
		
	}
	
}