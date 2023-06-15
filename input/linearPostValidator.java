package input;

import java.util.*;

import equation.LinearEquation;
import equation.Term;
import equation.VariableTerm;

public class linearPostValidator extends PostValidator {

	private static linearPostValidator instance = new linearPostValidator();

	public static linearPostValidator getInstance() {
		return instance;
	}

	public boolean isValid(ArrayList<Term> terms) {
		String exp = arrayToString(terms);
		if (checkDegree(exp) == 1) {
			return true;
		}
		System.out.println("The Equation is not a Linear one");
		return false;
	}

	public boolean isValidSimul(ArrayList<LinearEquation> equations) {
		HashMap<Character, Integer> variables = new HashMap<Character, Integer>();
		int eqNum = 0;
		for (LinearEquation eq : equations) {
			eqNum++;
			ArrayList<VariableTerm> terms = eq.getVTerms();
			for (VariableTerm t : terms) {
				if (variables.containsKey(t.getVar()))
					variables.put(t.getVar(), variables.get(t.getVar()) + 1);
				else
					variables.put(t.getVar(), 1);
			}
		}
		
		 Iterator it = variables.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        if(!pair.getValue().equals(equations.size()))
		        	return false;
		    }

		return true;

	}
}