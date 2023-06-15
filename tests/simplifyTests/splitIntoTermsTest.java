package tests.simplifyTests;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

import org.junit.jupiter.api.Test;

import simplify.Simplify;
public class splitIntoTermsTest {
	
	public String ListToString(ArrayList<String>[] terms) {
		return TestHelper.ListToString(terms);
	}
	@Test
	void test1() {
		Simplify sim = Simplify.getInstance();
		ArrayList<String>[] result = sim.splitIntoTerms("2x+3x+5");
		ArrayList<String>[] terms = new ArrayList[2];
		terms[0] = new ArrayList<String>();
		terms[1] = new ArrayList<String>();
		terms[1].add("+2x");
		terms[1].add("+3x");
		terms[0].add("5");
		assertEquals(ListToString(terms),ListToString(result));	
	}
	@Test
	void test2() {
		Simplify sim = Simplify.getInstance();
		ArrayList<String>[] result = sim.splitIntoTerms("+x^2-3");
		ArrayList<String>[] terms = new ArrayList[2];
		terms[0] = new ArrayList<String>();
		terms[1] = new ArrayList<String>();
		terms[1].add("+x^2");
		terms[0].add("-3");
		assertEquals(ListToString(terms),ListToString(result));	
	}
	@Test
	void test3() {
		Simplify sim = Simplify.getInstance();
		ArrayList<String>[] result = sim.splitIntoTerms("-x^2+3");
		ArrayList<String>[] terms = new ArrayList[2];
		terms[0] = new ArrayList<String>();
		terms[1] = new ArrayList<String>();
		terms[1].add("-x^2");
		terms[0].add("+3");
		assertEquals(ListToString(terms),ListToString(result));	
	}
	@Test
	void test4() {
		Simplify sim = Simplify.getInstance();
		ArrayList<String>[] result = sim.splitIntoTerms("-x^2+7x*-3+7");
		ArrayList<String>[] terms = new ArrayList[2];
		terms[0] = new ArrayList<String>();
		terms[1] = new ArrayList<String>();
		terms[1].add("-x^2");
		terms[1].add("+7x*-3");
		terms[0].add("+7");
		assertEquals(ListToString(terms),ListToString(result));	
	}
	@Test
	void test5() {
		Simplify sim = Simplify.getInstance();
		ArrayList<String>[] result = sim.splitIntoTerms("x*2x*22");
		ArrayList<String>[] terms = new ArrayList[2];
		terms[0] = new ArrayList<String>();
		terms[1] = new ArrayList<String>();
		terms[1].add("x*2x*22");
		assertEquals(ListToString(terms),ListToString(result));	
	}
	@Test
	void test6() {
		Simplify sim = Simplify.getInstance();
		ArrayList<String>[] result = sim.splitIntoTerms("-2*2");
		ArrayList<String>[] terms = new ArrayList[2];
		terms[0] = new ArrayList<String>();
		terms[1] = new ArrayList<String>();
		terms[1].add("-2*2");
		assertEquals(ListToString(terms),ListToString(result));	
	}
	@Test
	void test7() {
		Simplify sim = Simplify.getInstance();
		ArrayList<String>[] result = sim.splitIntoTerms("-2*-2");
		ArrayList<String>[] terms = new ArrayList[2];
		terms[0] = new ArrayList<String>();
		terms[1] = new ArrayList<String>();
		terms[1].add("-2*-2");
		assertEquals(ListToString(terms),ListToString(result));	
	}
	@Test
	void test8() {
		Simplify sim = Simplify.getInstance();
		ArrayList<String>[] result = sim.splitIntoTerms("-2*-2*x*x^2");
		ArrayList<String>[] terms = new ArrayList[2];
		terms[0] = new ArrayList<String>();
		terms[1] = new ArrayList<String>();
		terms[1].add("-2*-2*x*x^2");
		assertEquals(ListToString(terms),ListToString(result));	
	}
}