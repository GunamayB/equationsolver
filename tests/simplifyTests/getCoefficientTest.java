package tests.simplifyTests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import simplify.Simplify;
public class getCoefficientTest {
	@Test
	void test1() {
		Simplify sim = Simplify.getInstance();
		double result = sim.getCoefficient("2x");
		assertEquals(2.0, result);
	}
	@Test
	void test2() {
		Simplify sim = Simplify.getInstance();
		double result = sim.getCoefficient("+2x");
		assertEquals(2.0, result);
	}
	@Test
	void test3() {
		Simplify sim = Simplify.getInstance();
		double result = sim.getCoefficient("245.0x");
		assertEquals(245.0, result);
	}
	@Test
	void test4() {
		Simplify sim = Simplify.getInstance();
		double result = sim.getCoefficient("-35.0x");
		assertEquals(-35.0, result);
	}
	@Test
	void test5() {
		Simplify sim = Simplify.getInstance();
		double result = sim.getCoefficient("+x");
		assertEquals(1.0, result);
	}
	@Test
	void test6() {
		Simplify sim = Simplify.getInstance();
		double result = sim.getCoefficient("x");
		assertEquals(1.0, result);
	}
	@Test
	void test7() {
		Simplify sim = Simplify.getInstance();
		double result = sim.getCoefficient("-x");
		assertEquals(-1.0, result);
	}
	@Test
	void test8() {
		Simplify sim = Simplify.getInstance();
		double result = sim.getCoefficient("");
		assertEquals(0.0, result);
	}
}