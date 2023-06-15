package equation;

import java.util.ArrayList;

import solution.Solution;

public abstract class  PolynomialEquation extends Equation {

	public PolynomialEquation(ArrayList<Term> terms) {
		super(terms);
		// TODO Auto-generated constructor stub
	}
	
	public abstract ArrayList<Solution> solve();

}
