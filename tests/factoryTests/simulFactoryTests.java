package tests.factoryTests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import equation.LinearEquation;
import equation.SimultaneousEquation;
import factory.factoryLinear;
import factory.factorySimultaneous;

public class simulFactoryTests {
	@Test
	public void test1() {

		ArrayList<String> input = new ArrayList<>();
		input.add("2x+y");
		input.add("3x+3y");
		SimultaneousEquation equations = factorySimultaneous.getInstance().factoryMethod(input);
		ArrayList<String>result=new ArrayList<String>();
		ArrayList<LinearEquation>temp=equations.getEquations();
		for(LinearEquation eq:temp) {
			result.add(eq.toString());
		}
		
		String[] expected = { "2.0x+1.0y+0.0", "3.0x+3.0y+0.0" };
		assertArrayEquals(expected, result.toArray());

	}
	@Test
	public void test2() {
		ArrayList<String> input = new ArrayList<>();
		input.add("2x^2+y");
		input.add("3x+3y");
		SimultaneousEquation equations = factorySimultaneous.getInstance().factoryMethod(input);
		assertEquals(null, equations);
	}
	@Test
	public void test3() {
		ArrayList<String> input = new ArrayList<>();
		input.add("2x+y");
		input.add("3x+3z");
		SimultaneousEquation equations = factorySimultaneous.getInstance().factoryMethod(input);
		assertEquals(null, equations);
	}
	

}
