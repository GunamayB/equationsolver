package command;

import java.util.ArrayList;
import java.util.Scanner;

import equation.CubicEquation;
import equation.QuadraticEquation;
import equation.SimultaneousEquation;
import factory.factoryCubic;
import factory.factorySimultaneous;
import input.InputProcessor;
import input.InputValidator;
import input.TextInput;
import solution.Solution;

public class cmdSolveLinear implements Command {
	@Override
	public void execute(Scanner in) {
		ArrayList<String> inEqs = new ArrayList<>();
		String temp;
		boolean valid = true;
		System.out.println("Enter a set of equations and type 'done' to stop taking input:");
		do {
			temp = in.nextLine();
			if (!temp.equals("done"))
				if (InputValidator.getInstance().checkEqualsToSign(temp.split("")))
					inEqs.add(InputProcessor.getInstance().handleInput(temp));
				else {
					valid = false;
					break;
				}
		} while (!temp.equals("done"));
		for (String eq : inEqs) {
			if (!InputValidator.getInstance().isValid(eq)) {
				valid = false;
			}
		}

		for (int i = 0; i < inEqs.size(); i++) {
			inEqs.set(i, InputProcessor.getInstance().changeBrackets(inEqs.get(i)));
		}

		if (valid) {
			SimultaneousEquation eq = factorySimultaneous.getInstance().factoryMethod(inEqs);
			if (eq != null) {
				ArrayList<Solution> solutions = eq.solve();
				System.out.println("Answers:");
				for (int i=0;i<solutions.size();i++)
					if(i<solutions.size()-1)
						System.out.print(solutions.get(i).toString()+", ");
					else
						System.out.print(solutions.get(i).toString());
			}

		}

	}

}
