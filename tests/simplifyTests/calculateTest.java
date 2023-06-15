package tests.simplifyTests;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import simplify.Simplify;
public class calculateTest {
	@Test
	void test1() {
		Simplify sim = Simplify.getInstance();
		ArrayList<String>[] terms = new ArrayList[2];
		terms[0] = new ArrayList<String>();
		terms[1] = new ArrayList<String>();
		
		terms[1].add("3x^2");
		terms[1].add("16x^2");
		terms[1].add("4x");
		String result = sim.calculate(terms);
		assertEquals("+19.0x^2+4.0x",result);
	}
	@Test
	void test2() {
		Simplify sim = Simplify.getInstance();
		ArrayList<String>[] terms = new ArrayList[2];
		terms[0] = new ArrayList<String>();
		terms[1] = new ArrayList<String>();
		
		terms[1].add("3x^2");
		terms[1].add("16x");
		terms[1].add("4y");
		terms[1].add("-16y");
		String result = sim.calculate(terms);
		assertEquals("+3.0x^2+16.0x-12.0y",result);
	}
	@Test
	void test3() {
		Simplify sim = Simplify.getInstance();
		ArrayList<String>[] terms = new ArrayList[2];
		terms[0] = new ArrayList<String>();
		terms[1] = new ArrayList<String>();
		
		terms[1].add("+3x^2*x");
		terms[1].add("-16x^0");
		terms[1].add("-4y^1");
		terms[1].add("-16y");
		String result = sim.calculate(terms);
		assertEquals("+3.0x^3-20.0y",result);
	}
	@Test
	void test4() {
		Simplify sim = Simplify.getInstance();
		ArrayList<String>[] terms = new ArrayList[2];
		terms[0] = new ArrayList<String>();
		terms[1] = new ArrayList<String>();
		
		terms[1].add("+3x^2*-x");//imp
		terms[1].add("-16x^0");
		terms[1].add("-4y^1");
		terms[1].add("-16y");
		String result = sim.calculate(terms);
		assertEquals("-3.0x^3-20.0y",result);
	}
}