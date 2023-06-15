package tests.factoryTests;

import static org.junit.Assert.assertArrayEquals;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import equation.Term;
import equation.VariableTerm;
import factory.Factory;
import factory.factoryCubic;

public class factoryGetTermsTests {

	public ArrayList<String> toString(ArrayList<Term> terms) {
		ArrayList<String> strResult = new ArrayList<>();
		for (Term t : terms) {
			strResult.add(t.toString());
		}
		return strResult;
	}

	@Test
	public void testConstructor1() {
		ArrayList<Term> result = factoryCubic.getInstance().simplifyInput("22x");
		ArrayList<String> expected = new ArrayList<>();
		expected.add("22.0x");
		expected.add("0.0");
		ArrayList<String> strResult = toString(result);
		assertArrayEquals(expected.toArray(), strResult.toArray());
	}
	@Test
	public void testConstructor2() {
		ArrayList<Term> result = factoryCubic.getInstance().simplifyInput("22x^2");
		ArrayList<String> expected = new ArrayList<>();
		expected.add("22.0x^2");
		expected.add("0.0");
		ArrayList<String> strResult = toString(result);
		assertArrayEquals(expected.toArray(), strResult.toArray());
	}
	@Test
	public void testConstructor3() {
		ArrayList<Term> result = factoryCubic.getInstance().simplifyInput("22x+3");
		ArrayList<String> expected = new ArrayList<>();
		expected.add("22.0x");
		expected.add("3.0");
		ArrayList<String> strResult = toString(result);
		assertArrayEquals(expected.toArray(), strResult.toArray());
	}
	@Test
	public void testConstructor4() {
		ArrayList<Term> result = factoryCubic.getInstance().simplifyInput("22x^2+3");
		ArrayList<String> expected = new ArrayList<>();
		expected.add("22.0x^2");
		expected.add("3.0");
		ArrayList<String> strResult = toString(result);
		assertArrayEquals(expected.toArray(), strResult.toArray());
	}
	@Test
	public void testConstructor5() {
		ArrayList<Term> result = factoryCubic.getInstance().simplifyInput("22x^2-3");
		ArrayList<String> expected = new ArrayList<>();
		expected.add("22.0x^2");
		expected.add("-3.0");
		ArrayList<String> strResult = toString(result);
		assertArrayEquals(expected.toArray(), strResult.toArray());
	}
	@Test
	public void testConstructor6() {
		ArrayList<Term> result = factoryCubic.getInstance().simplifyInput("-22x^2-3");
		ArrayList<String> expected = new ArrayList<>();
		expected.add("-22.0x^2");
		expected.add("-3.0");
		ArrayList<String> strResult = toString(result);
		assertArrayEquals(expected.toArray(), strResult.toArray());
	}
	@Test
	public void testConstructor7() {
		ArrayList<Term> result = factoryCubic.getInstance().simplifyInput("356x^3+22x^2+3");
		ArrayList<String> expected = new ArrayList<>();
		expected.add("356.0x^3");
		expected.add("22.0x^2");
		expected.add("3.0");
		ArrayList<String> strResult = toString(result);
		assertArrayEquals(expected.toArray(), strResult.toArray());
	}

	@Test
	public void testConstructor8() {
		ArrayList<Term> result = factoryCubic.getInstance().simplifyInput("356x^3-22x^2+3");
		ArrayList<String> expected = new ArrayList<>();
		expected.add("356.0x^3");
		expected.add("-22.0x^2");
		expected.add("3.0");
		ArrayList<String> strResult = toString(result);
		assertArrayEquals(expected.toArray(), strResult.toArray());
	}
	@Test
	public void testConstructor9() {
		ArrayList<Term> result = factoryCubic.getInstance().simplifyInput("-356x^3-22x^2-3");
		ArrayList<String> expected = new ArrayList<>();
		expected.add("-356.0x^3");
		expected.add("-22.0x^2");
		expected.add("-3.0");
		ArrayList<String> strResult = toString(result);
		assertArrayEquals(expected.toArray(), strResult.toArray());
	}
	@Test
	public void testConstructor10() {
		ArrayList<Term> result = factoryCubic.getInstance().simplifyInput("-356x^3-22x^2");
		ArrayList<String> expected = new ArrayList<>();
		expected.add("-356.0x^3");
		expected.add("-22.0x^2");
		expected.add("0.0");
		ArrayList<String> strResult = toString(result);
		assertArrayEquals(expected.toArray(), strResult.toArray());
	}
}
