package input;

import java.util.*;

import java.io.File;
import command.cmdSimplify;
import command.cmdSolveCubic;
import command.cmdSolveLinear;
import command.cmdSolveQuadratic;

public class Main {
	public static void main(String[] args) {
		Scanner in = null;
		System.out.println("Hi! I am your best buddy, the Equation Solver!");
		System.out.println("This program can simplify the equations you input and then solve them for you!");
		if(args.length>0) {
			 try {
				in = new Scanner(new File("test1.txt"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			 in = TextInput.getInstance().getScanner();
		}
		String input;
		do {
			
			System.out.println("\n____________________________________________________\nList of available commands:\n\n1 : Simultaneous Linear Equations\n2: Quadratic Equation\n3: Cubic Equation\n4: Simplify an equation\n-1: Terminate the program\n\nEnter a command to solve equations or terminate:");
					
			input = in.nextLine();
			if (input.equals("1")) {
				new cmdSolveLinear().execute(in);
			} else if (input.equals("2")) {
				new cmdSolveQuadratic().execute(in);
			} else if (input.equals("3")) {
				new cmdSolveCubic().execute(in);
			}
			else if(input.equals("4")) {
				new cmdSimplify().execute(in);
			}
			else if(input.equals("-1")) {
				System.out.println("Thank you for using the Equation Solver. Have a good day!");
			}
			else {
				System.out.println("Invalid choice.");
				
			}
		} while(!input.equals("-1"));
	}
}
