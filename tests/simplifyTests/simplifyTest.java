package tests.simplifyTests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import simplify.Simplify;

public class simplifyTest {
	@Test
	void test1() {
		Simplify sim = Simplify.getInstance();
		String result = sim.simplify("24x+(36x+30)");
		assertEquals("+60.0x+30.0", result);
	}
	@Test
	void test2() {
		Simplify sim = Simplify.getInstance();
		String result = sim.simplify("24x+(36x+(30-40))");
		assertEquals("+60.0x-10.0", result);
	}
	@Test
	void test3() {
		Simplify sim = Simplify.getInstance();
		String result = sim.simplify("(((24x+(36x+30))))");
		assertEquals("+60.0x+30.0", result);
	}
	@Test
	void test4() {
		Simplify sim = Simplify.getInstance();
		String result = sim.simplify("24x+(36x+30)(x+2)");
		assertEquals("+126.0x+36.0x^2+60.0", result);
	}
	@Test
	void test5() {
		Simplify sim = Simplify.getInstance();
		String result = sim.simplify("((36x+30)(x+2)(2))");
		assertEquals("+204.0x+72.0x^2+120.0", result);
	}
	@Test
	void test6() {
		Simplify sim = Simplify.getInstance();
		String result = sim.simplify("((36x+30)(x+2)(2))");
		assertEquals("+204.0x+72.0x^2+120.0", result);
	}
	@Test
	void test7() {
		Simplify sim = Simplify.getInstance();
		String result = sim.simplify("(1-(36x+30)(x+2)(2))");
		assertEquals("-204.0x-72.0x^2-119.0", result);
	}
	@Test
	void test8() {
		Simplify sim = Simplify.getInstance();
		String result = sim.simplify("(1-(36x+30)*(-(x+2))*2)");
		assertEquals("+204.0x+72.0x^2+121.0", result);
	}
	@Test
	void test9() {
		Simplify sim = Simplify.getInstance();
		String result = sim.simplify("(1-(36x+30)*(x+2)*2)");
		assertEquals("-204.0x-72.0x^2-119.0", result);
	}
}