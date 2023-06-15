package input;

import java.util.Scanner;

public class TextInput {
	private static TextInput ins = new TextInput();
	private Scanner in;

	private TextInput() {
		in = new Scanner(System.in);
	}
	
	public static TextInput getInstance() {
		return ins;
	}
	
	public Scanner getScanner() {
		return in;
	}
	
	public void closeScanner() {
		in.close();
	}
}
