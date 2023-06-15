package tests.simplifyTests;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

import org.junit.jupiter.api.Test;

import simplify.Simplify;
public class multiplyTerm2Test {
	@Test
	void test1() {
		Simplify sim = Simplify.getInstance();
		String result = sim.multiplyTerm(25.0,"2x");
		assertEquals("50.0x",result);
	}
	@Test
	void test2() {
		Simplify sim = Simplify.getInstance();
		String result = sim.multiplyTerm(-25.0,"x");
		assertEquals("-25.0x",result);
	}
}
