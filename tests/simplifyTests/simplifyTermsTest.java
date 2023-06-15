package tests.simplifyTests;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

import org.junit.jupiter.api.Test;

import simplify.Simplify;
public class simplifyTermsTest {
	
	public String ListToString(ArrayList<String>[] terms) {
		return TestHelper.ListToString(terms);
	}
	@Test
	void test1() {
		Simplify sim = Simplify.getInstance();
		ArrayList<String>[] terms = new ArrayList[2];
		terms[0] = new ArrayList<String>();
		terms[1] = new ArrayList<String>();
		terms[1].add("+2x*3");
		terms[1].add("-3x*5");
		terms[0].add("5");
		ArrayList<String>[] result = sim.simplifyTerms(terms);
		terms[1].set(0, "6.0x");
		terms[1].set(1, "-15.0x");
		assertEquals(ListToString(terms),ListToString(result));
	}
	@Test
	void test2() {
		Simplify sim = Simplify.getInstance();
		ArrayList<String>[] terms = new ArrayList[2];
		terms[0] = new ArrayList<String>();
		terms[1] = new ArrayList<String>();
		terms[1].add("+2x*3x");
		terms[1].add("-3y*-5.5y");
		terms[0].add("5");
		ArrayList<String>[] result = sim.simplifyTerms(terms);
		terms[1].set(0, "6.0x^2");
		terms[1].set(1, "-16.5y^2");
		assertEquals(ListToString(terms),ListToString(result));
	}
	@Test
	void test3() {
		Simplify sim = Simplify.getInstance();
		ArrayList<String>[] terms = new ArrayList[2];
		terms[0] = new ArrayList<String>();
		terms[1] = new ArrayList<String>();
		terms[1].add("+2x*3x");
		terms[1].add("-3y*-5.5y");
		ArrayList<String>[] result = sim.simplifyTerms(terms);
		terms[1].set(0, "6.0x^2");
		terms[1].set(1, "-16.5y^2");
		assertEquals(ListToString(terms),ListToString(result));
	}
	@Test
	void test4() {
		Simplify sim = Simplify.getInstance();
		ArrayList<String>[] terms = new ArrayList[2];
		terms[0] = new ArrayList<String>();
		terms[1] = new ArrayList<String>();
		terms[1].add("+2x");
		terms[1].add("-3y");
		terms[0].add("5*100");
		terms[0].add("-60*3.0");
		ArrayList<String>[] result = sim.simplifyTerms(terms);
		terms[0].set(0, "500.0");
		terms[0].set(1, "-180.0");
		assertEquals(ListToString(terms),ListToString(result));
	}
	@Test
	void test5() {
		Simplify sim = Simplify.getInstance();
		ArrayList<String>[] terms = new ArrayList[2];
		terms[0] = new ArrayList<String>();
		terms[1] = new ArrayList<String>();
		terms[1].add("2*-3.0*+2x*3x");
		terms[1].add("-3y*4");
		ArrayList<String>[] result = sim.simplifyTerms(terms);
		terms[1].set(0, "-36.0x^2");
		terms[1].set(1, "-12.0y");
		assertEquals(ListToString(terms),ListToString(result));
	}
}