package factory;

import java.util.ArrayList;

import equation.Equation;
import equation.LinearEquation;
import equation.QuadraticEquation;
import equation.Term;
import input.linearPostValidator;
import input.quadraticPostValidator;

public class factoryLinear extends Factory {

	private static factoryLinear instance = new factoryLinear();

	public static factoryLinear getInstance() {
		return instance;
	}

	private factoryLinear() {
	}

	@Override
	public Equation factoryMethod(String input) {
		ArrayList<Term> terms = this.simplifyInput(input);
		if (linearPostValidator.getInstance().isValid(terms))
			return new LinearEquation(terms);
		return null;
	}

}