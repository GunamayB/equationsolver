package factory;

import java.util.ArrayList;

import equation.*;
import simplify.Simplify;

public abstract class Factory {
	
	
	
	public abstract Equation factoryMethod(String input);
	
	public ArrayList<Term> simplifyInput(String input) {
		ArrayList<Term> result = new ArrayList<>();
		String temp = Simplify.getInstance().simplify(input);
		System.out.println("\nSimplified equation: "+temp+"=0.0\n");
		ArrayList<String>[] strTerms = Simplify.getInstance().splitIntoTerms(temp);
		for(int i =0; i<strTerms[1].size();i++) {
			result.add(new VariableTerm(strTerms[1].get(i)));
		}
//		if(strTerms[0].isEmpty()) {
//			strTerms[0].add("0.0");
//		}
		result.add(new ConstantTerm(strTerms[0].get(0)));
		return result;
	}
}

