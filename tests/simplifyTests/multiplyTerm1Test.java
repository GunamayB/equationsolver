package tests.simplifyTests;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

import org.junit.jupiter.api.Test;

import simplify.Simplify;
public class multiplyTerm1Test {
	@Test
	void test1() {
		Simplify sim = Simplify.getInstance();
		String result = sim.multiplyTerm("25x","2x");
		assertEquals("50.0x^2", result);
	}
	@Test
	void test2() {
		Simplify sim = Simplify.getInstance();
		String result = sim.multiplyTerm("-30x^2","x");
		assertEquals("-30.0x^3", result);
	}
}
