package tests.simplifyTests;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

import org.junit.jupiter.api.Test;

import simplify.Simplify;
public class correctPowerTest {
	
	public String ListToString(ArrayList<String>[] terms) {
		
		return TestHelper.ListToString(terms);
	}
	
	@Test
	void test1() {
		Simplify sim = Simplify.getInstance();
		ArrayList[] terms = new ArrayList[2];
		terms[1] = new ArrayList();
		terms[0] = new ArrayList();
		
		terms[1].add("24x^2");
		terms[1].add("-34.0x");
		terms[1].add("32.0x^3");
		terms[0].add("34.0");
		
		ArrayList[] result = sim.correctPower(terms);
		
		assertEquals( ListToString(terms),ListToString(result));
	}
	@Test
	void test2() {
		Simplify sim = Simplify.getInstance();
		ArrayList[] terms = new ArrayList[2];
		terms[1] = new ArrayList();
		terms[0] = new ArrayList();
		
		terms[1].add("24x^2");
		terms[1].add("-34.0x^0");
		terms[1].add("x^0");
		terms[0].add("34.0");
		
		ArrayList[] result = sim.correctPower(terms);
		terms[1].remove("-34.0x^0");
		terms[1].remove("x^0");
		terms[0].add("-34.0");
		terms[0].add("1.0");
		
		assertEquals(ListToString(terms),ListToString(result));
	}
	@Test
	void test3() {
		Simplify sim = Simplify.getInstance();
		ArrayList[] terms = new ArrayList[2];
		terms[1] = new ArrayList();
		terms[0] = new ArrayList();
		
		terms[1].add("24x^2");
		terms[1].add("-34.0x^1");
		terms[1].add("x^1");
		terms[0].add("34.0");
		
		ArrayList[] result = sim.correctPower(terms);
		terms[1].set(1, "-34.0x");
		terms[1].set(2, "x");
		assertEquals(ListToString(terms),ListToString(result));
	}
	@Test
	void test4() {
		Simplify sim = Simplify.getInstance();
		ArrayList[] terms = new ArrayList[2];
		terms[1] = new ArrayList();
		terms[0] = new ArrayList();
		
		terms[1].add("24x^2");
		terms[1].add("-x^1");
		terms[1].add("+x^1");
		terms[1].add("-x^0");
		terms[1].add("+x^0");
		terms[1].add("-x^2");
		terms[0].add("34.0");
		
		ArrayList[] result = sim.correctPower(terms);
		terms[1].remove("-x^0");
		terms[1].remove("+x^0");
		terms[1].set(1, "-x");
		terms[1].set(2, "x");
		terms[0].add("-1.0");
		terms[0].add("1.0");
		assertEquals(ListToString(terms),ListToString(result));
	}
	@Test
	void test5() {
		Simplify sim = Simplify.getInstance();
		ArrayList[] terms = new ArrayList[2];
		terms[1] = new ArrayList();
		terms[0] = new ArrayList();
		
		terms[1].add("24x^2");
		terms[1].add("34.0x^0");
		terms[1].add("x^0");
		terms[0].add("34.0");
		
		ArrayList[] result = sim.correctPower(terms);
		terms[1].remove("34.0x^0");
		terms[1].remove("x^0");
		terms[0].add("34.0");
		terms[0].add("1.0");
		
		assertEquals(ListToString(terms),ListToString(result));
	}
}





