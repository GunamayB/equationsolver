package tests.factoryTests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import equation.CubicEquation;
import equation.Term;
import factory.factoryCubic;

public class cubicFactoryTests {

	@Test
	public void test1() {
		CubicEquation result = (CubicEquation) factoryCubic.getInstance().factoryMethod("22x^3");
		
		assertEquals("22.0x^3+0.0", result.toString());
		
	}
	@Test
	public void test2() {
		CubicEquation result = (CubicEquation) factoryCubic.getInstance().factoryMethod("22x^4");
		
		assertEquals(null, result);
		
	}
}
