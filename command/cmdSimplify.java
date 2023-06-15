package command;
import input.TextInput;
import java.util.*;

import equation.QuadraticEquation;
import factory.factoryQuadratic;
import simplify.Simplify;
import solution.Solution;
import input.InputProcessor;
import input.InputValidator;

public class cmdSimplify implements Command{
	public void execute(Scanner abc) {
		System.out.println("Enter an equation to simplify:");
		String inEq = abc.nextLine();
		if (InputValidator.getInstance().checkEqualsToSign(inEq.split(""))) {
			inEq = InputProcessor.getInstance().handleInput(inEq);
			if (InputValidator.getInstance().isValid(inEq)) {
				inEq = InputProcessor.getInstance().changeBrackets(inEq);
				System.out.println("Answer:\n"+Simplify.getInstance().simplify(inEq)+"=0.0");
			}
		}
	}
}
