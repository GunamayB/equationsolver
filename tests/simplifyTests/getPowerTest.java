package tests.simplifyTests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import simplify.Simplify;
public class getPowerTest {
	@Test
	void test1() {
		Simplify sim = Simplify.getInstance();
		int result = sim.getPower("x");
		assertEquals(1, result);
	}
	@Test
	void test2() {
		Simplify sim = Simplify.getInstance();
		int result = sim.getPower("x^3");
		assertEquals(3, result);
	}
}