package factory;

import java.util.ArrayList;

import equation.CubicEquation;
import equation.Equation;
import equation.Term;
import input.cubicPostValidator;
import input.quadraticPostValidator;

public class factoryCubic extends Factory {

	private static factoryCubic instance = new factoryCubic();

	public static factoryCubic getInstance() {
		return instance;
	}

	private factoryCubic() {
	}

	@Override
	public Equation factoryMethod(String input) {
		ArrayList<Term> terms = this.simplifyInput(input);
		if (cubicPostValidator.getInstance().isValid(terms))
			return new CubicEquation(terms);
		return null;
	}

}
