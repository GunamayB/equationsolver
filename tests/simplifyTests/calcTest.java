package tests.simplifyTests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import simplify.Simplify;

public class calcTest {
	@Test
	void test1() {
		Simplify sim = Simplify.getInstance();
		String result = sim.calc("24x+36x+30");
		assertEquals("+60.0x+30.0", result);
	}
	@Test
	void test2() {
		Simplify sim = Simplify.getInstance();
		String result = sim.calc("24x+36y+30-4x-6y");
		assertEquals("+20.0x+30.0y+30.0", result);
	}
	@Test
	void test3() {
		Simplify sim = Simplify.getInstance();
		String result = sim.calc("30x+2x+68-8+40+32y*y*-2");
		assertEquals("+32.0x-64.0y^2+100.0", result);
	}
	@Test
	void test4() {
		Simplify sim = Simplify.getInstance();
		String result = sim.calc("30x+2x-68+8-40+32y*y*-2");
		assertEquals("+32.0x-64.0y^2-100.0", result);
	}
}