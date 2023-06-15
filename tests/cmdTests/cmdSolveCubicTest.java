package tests.cmdTests;


import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.Scanner;
import org.junit.Test;

import command.cmdSolveCubic;

public class cmdSolveCubicTest {
	
	@Test
	public void test1() throws Exception{
		setOutput();
		Scanner in = new Scanner("(x-2)(x+3)(x+4)=0");
		new cmdSolveCubic().execute(in);
		assertEquals("x=-4.00, x=2.00, x=-3.00",getOutput().substring(getOutput().length()-24));
		
	}
	@Test
	public void test2() throws Exception{
		setOutput();
		Scanner in = new Scanner("(x-2)(x+3)(x+4)0");
		new cmdSolveCubic().execute(in);
		assertEquals("There needs to be only one Equals To Sign",getOutput().substring(getOutput().length()-43,getOutput().length()-2));
		
	}
	@Test
	public void test3() throws Exception{
		setOutput();
		Scanner in = new Scanner("(x-2)!(x+3)(x+4)=0");
		new cmdSolveCubic().execute(in);
		assertEquals("Invalid Characters!",getOutput().substring(getOutput().length()-21,getOutput().length()-2));
		
	}
	
	//Output checking support
	PrintStream oldPrintStream;
	ByteArrayOutputStream bos;

	private void setOutput() throws Exception {
		oldPrintStream = System.out;
		bos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bos));
	}

	private String getOutput() { // throws Exception
		System.setOut(oldPrintStream);
		return bos.toString();
	}
}
