package tests.factoryTests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import equation.CubicEquation;
import equation.LinearEquation;
import equation.Term;
import factory.factoryCubic;
import factory.factoryLinear;

public class linearFactoryTests {

	@Test
	public void test1() {
		LinearEquation result = (LinearEquation) factoryLinear.getInstance().factoryMethod("22x");
		
		assertEquals("22.0x+0.0", result.toString());
		
	}
	@Test
	public void test2() {
		LinearEquation result = (LinearEquation) factoryLinear.getInstance().factoryMethod("22x+4y");
		
		assertEquals("22.0x+4.0y+0.0", result.toString());
		
	}
	@Test
	public void test3() {
		LinearEquation result = (LinearEquation) factoryLinear.getInstance().factoryMethod("22x^5+4y");
		
		assertEquals(null, result);
		
	}
	
	
}
