package tests.systemTest;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Scanner;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Test;

import input.Main;

public class mainTest {

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
		write(file, "1\n2x+y=0\n3x-5+0y=0\ndone\n-1");
		Scanner ob = new Scanner(file);
		String[] array= {"test"};
		new Main().main(array);
		file.delete();
		assertEquals("x=1.67, y=-3.33",getOutput().substring(getOutput().length()-332,getOutput().length()-317));
		
	}
	@Test
	public void test2() throws Exception{
		setOutput();
		File file = createFile("test1.txt");
		write(file, "2\n(x-1)(x-2)=0\n-1");
		Scanner ob = new Scanner(file);
		String[] array= {"test"};
		new Main().main(array);
		file.delete();
		assertEquals("x=2.00, x=1.00",getOutput().substring(getOutput().length()-331,getOutput().length()-317));
		
	}
	@Test
	public void test3() throws Exception{
		setOutput();
		File file = createFile("test1.txt");
		write(file, "3\n(x-1)(x-2)(x+3)=0\n-1");
		Scanner ob = new Scanner(file);
		String[] array= {"test"};
		new Main().main(array);
		file.delete();
		assertEquals("x=-3.00, x=2.00, x=1.00",getOutput().substring(getOutput().length()-340,getOutput().length()-317));
		
	}
	@Test
	public void test4() throws Exception{
		setOutput();
		File file = createFile("test1.txt");
		write(file, "4\n(x-1)(x-2)(x+3)=0\n-1");
		Scanner ob = new Scanner(file);
		String[] array= {"test"};
		new Main().main(array);
		file.delete();
		assertEquals("-7.0x+0.0x^2+1.0x^3+6.0=0.0",getOutput().substring(getOutput().length()-346,getOutput().length()-319));
		
	}
	@Test
	public void test5() throws Exception{
		setOutput();
		File file = createFile("test1.txt");
		write(file, "5\n(x-1)(x-2)(x+3)=0\n-1");
		Scanner ob = new Scanner(file);
		String[] array= {"test"};
		new Main().main(array);
		file.delete();
		assertEquals("Invalid choice.",getOutput().substring(getOutput().length()-334,getOutput().length()-319));
		
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
