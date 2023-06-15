package command;

import java.util.ArrayList;
import java.util.Scanner;

import equation.CubicEquation;
import equation.QuadraticEquation;
import equation.SimultaneousEquation;
import factory.factoryCubic;
import factory.factoryQuadratic;
import factory.factorySimultaneous;
import input.InputProcessor;
import input.InputValidator;
import input.TextInput;
import solution.Solution;

public class cmdSolveQuadratic implements Command {

	@Override
	public void execute(Scanner in) {
		System.out.println("Enter a quadratic equation:");
		String inEq = in.nextLine();
		if (InputValidator.getInstance().checkEqualsToSign(inEq.split(""))) {
			inEq = InputProcessor.getInstance().handleInput(inEq);
			
			if (InputValidator.getInstance().isValid(inEq)) {
				
				inEq = InputProcessor.getInstance().changeBrackets(inEq);
				QuadraticEquation eq = (QuadraticEquation) factoryQuadratic.getInstance().factoryMethod(inEq);

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

}
