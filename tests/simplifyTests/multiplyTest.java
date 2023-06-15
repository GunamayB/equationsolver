package tests.simplifyTests;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

import org.junit.jupiter.api.Test;

import simplify.Simplify;
public class multiplyTest {
	@Test
	void test1() {
		Simplify sim = Simplify.getInstance();
		String result = sim.multiply("25.0","2x");
		assertEquals( "+50.0x+0.0",result);
	}
	@Test
	void test2() {
		Simplify sim = Simplify.getInstance();
		String result = sim.multiply("x+32.0y","2");
		assertEquals("+2.0x+64.0y+0.0",result);
	}
	@Test
	void test3() {
		Simplify sim = Simplify.getInstance();
		String result = sim.multiply("x+3.0-5.0","2.0");
		assertEquals("+2.0x-4.0",result);
	}
	@Test
	void test4() {
		Simplify sim = Simplify.getInstance();
		String result = sim.multiply("x+32.0","2x^2-x");
		assertEquals( "+63.0x^2-32.0x+2.0x^3+0.0",result);
	}
}
