package tests.cmdTests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Scanner;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Test;

import command.cmdSolveLinear;

public class cmdSolveLinearTest {

	public File createFile(String filename) {
		File file = new File(filename);
		try {
			file.createNewFile();
		} catch(IOException e) {
			return null;
		}
		return file;
	}
	
	public void write(File file, String text) {
		try {
			FileWriter writer = new FileWriter(file);
			
			writer.write(text);
			writer.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test1() throws Exception{
		setOutput();
		File file = createFile("test1.txt");
		write(file, "2x+y=0\n3x-5+0y=0\ndone");
		Scanner ob = new Scanner(file);
		
		new cmdSolveLinear().execute(ob);
		file.delete();
		assertEquals("x=1.67, y=-3.33",getOutput().substring(getOutput().length()-15));
		
	}
	
	@Test
	public void test2() throws Exception{
		setOutput();
		File file = createFile("test1.txt");
		write(file, "2x+y=0\n3x-5+0y=!0\ndone");
		Scanner ob = new Scanner(file);
		
		new cmdSolveLinear().execute(ob);

		file.delete();
		assertEquals("Invalid Characters!",getOutput().substring(getOutput().length()-21,getOutput().length()-2));
		
	}
	@Test
	public void test3() throws Exception{
		setOutput();
		File file = createFile("test1.txt");
		write(file, "2x+y=0\n3x-5+0y!0\ndone");
		Scanner ob = new Scanner(file);
		
		new cmdSolveLinear().execute(ob);

		file.delete();
		assertEquals("There needs to be only one Equals To Sign",getOutput().substring(getOutput().length()-43, getOutput().length()-2));
		
	}
	@Test
	public void test4() throws Exception{
		setOutput();
		File file = createFile("test1.txt");
		write(file, "2x+y=0\n3x-5=0\ndone");
		Scanner ob = new Scanner(file);
		
		new cmdSolveLinear().execute(ob);
		file.delete();
		assertEquals("Invalid set of equations. All equations should have all variables (input variables with coefficient 0 if they are not a part of that equation).",getOutput().substring(getOutput().length()-145,getOutput().length()-2));
		
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
