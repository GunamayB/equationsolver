package tests.simplifyTests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import simplify.Simplify;

public class isConstantTest {
	@Test
	void test1() {
		Simplify sim = Simplify.getInstance();
		boolean result = sim.isConstant("24");
		assertEquals(true, result);
	}
	@Test
	void test2() {
		Simplify sim = Simplify.getInstance();
		boolean result = sim.isConstant("1.0");
		assertEquals(true, result);
	}
	@Test
	void test3() {
		Simplify sim = Simplify.getInstance();
		boolean result = sim.isConstant("24^1");
		assertEquals(true, result);
	}
	@Test
	void test4() {
		Simplify sim = Simplify.getInstance();
		boolean result = sim.isConstant("24x");
		assertEquals(false, result);
	}
	@Test
	void test5() {
		Simplify sim = Simplify.getInstance();
		boolean result = sim.isConstant("24x^2");
		assertEquals(false, result);
	}
	@Test
	void test6() {
		Simplify sim = Simplify.getInstance();
		boolean result = sim.isConstant("24X^2");
		assertEquals(false, result);
	}
}
