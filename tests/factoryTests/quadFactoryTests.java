package tests.factoryTests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import equation.CubicEquation;
import equation.QuadraticEquation;
import equation.Term;
import factory.factoryCubic;
import factory.factoryQuadratic;

public class quadFactoryTests {

	@Test
	public void test1() {
		QuadraticEquation result = (QuadraticEquation) factoryQuadratic.getInstance().factoryMethod("22x^2+x");
		
		assertEquals("22.0x^2+1.0x+0.0", result.toString());
		
	}
	@Test
	public void test2() {
		QuadraticEquation result = (QuadraticEquation) factoryQuadratic.getInstance().factoryMethod("22x^4");
		
		assertEquals(null, result);
		
	}
}
