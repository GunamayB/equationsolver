package tests.simultaneousEquationTest;
import static org.junit.Assert.assertArrayEquals;

import java.lang.reflect.Array;
//test solve
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import equation.ConstantTerm;
import equation.LinearEquation;
import equation.SimultaneousEquation;
import equation.Term;
import equation.VariableTerm;
import solution.Solution;

public class SolveSimultaneousEquationTest {
	
	public double[][] toArray(ArrayList<Solution> solution) {
		double[][]result = new double[solution.size()][1];
		for(int i =0; i<solution.size();i++) {
			result[i][0] = solution.get(i).getValue();
		}
		return result;
	}
	
	

	@BeforeEach
	public void setUp() throws Exception {  }
	
	public void tearDown() {}

	@Test
	public void test_1() {
        
        double[][] expected = {
            {11}, 
            {8}, 
        };

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
		
        SimultaneousEquation simul = new SimultaneousEquation(equations);
        double[][] result = toArray(simul.solve());
        assertArrayEquals(result, expected);
		
    }

    @Test
	public void test_2() {
        
        double[][] expected = {
            {-0.9999999999999998}, 
            {4}, 
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
        double[][] result = toArray(simul.solve());
        assertArrayEquals(result, expected);
		
    }

    @Test
	public void test_3() {
        
        double[][] expected = {
        		{0.9999999999999996}, 
                {4},
                {-1.9999999999999998}, 
        };

        ArrayList<Term> eq1= new ArrayList<>();
        eq1.add(new VariableTerm("4x"));
		eq1.add(new VariableTerm("-3y"));
		eq1.add(new VariableTerm("z"));
		eq1.add(new ConstantTerm("10"));
		
		ArrayList<Term> eq2= new ArrayList<>();
		eq2.add(new VariableTerm("2x"));
		eq2.add(new VariableTerm("y"));
		eq2.add(new VariableTerm("3z"));
		eq2.add(new ConstantTerm("0"));
		
		ArrayList<Term> eq3= new ArrayList<>();
		eq3.add(new VariableTerm("-x"));
		eq3.add(new VariableTerm("2y"));
		eq3.add(new VariableTerm("-5z"));
		eq3.add(new ConstantTerm("-17"));
		

		ArrayList<LinearEquation> equations = new ArrayList<>();
		equations.add(new LinearEquation(eq1));
		equations.add(new LinearEquation(eq2));
		equations.add(new LinearEquation(eq3));
		
        SimultaneousEquation simul = new SimultaneousEquation(equations);
        double[][] result = toArray(simul.solve());
        assertArrayEquals(result, expected);
		
    }
	
}