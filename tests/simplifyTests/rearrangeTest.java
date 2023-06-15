package tests.simplifyTests;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

import org.junit.jupiter.api.Test;

import simplify.Simplify;

public class rearrangeTest {

	public String ListToString(ArrayList<String>[] terms) {
		return TestHelper.ListToString(terms);
	}

	@Test
	void test1() {
		Simplify sim = Simplify.getInstance();
		ArrayList<String>[] terms = new ArrayList[2];
		terms[0] = new ArrayList<String>();
		terms[1] = new ArrayList<String>();
		terms[1].add("+2x");
		terms[1].add("+3x");
		terms[0].add("5");
		ArrayList<String>[] result = sim.rearrange(terms);

		assertEquals(ListToString(terms), ListToString(result));
	}

	@Test
	void test2() {
		Simplify sim = Simplify.getInstance();
		ArrayList<String>[] terms = new ArrayList[2];
		terms[0] = new ArrayList<String>();
		terms[1] = new ArrayList<String>();
		terms[1].add("+2x");
		terms[1].add("+3x");
		terms[1].add("5");
		terms[0].add("5");
		ArrayList<String>[] result = sim.rearrange(terms);
		terms[0].add("5");
		terms[1].remove("5");
		assertEquals(ListToString(terms), ListToString(result));
	}
}