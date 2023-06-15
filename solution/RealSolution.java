package solution;

import equation.VariableTerm;

public class RealSolution implements Solution {
	private char variable;
	private double value;
	private boolean solutionExists;
	
	public RealSolution(char var, double val) { 
		this.variable=var;
		this.value=val;
	}
	
	@Override
	public String toString() {
		return String.format("%s=%.2f", variable, value);
	}
	
	public Double getValue() {
		return value;
	}

}
