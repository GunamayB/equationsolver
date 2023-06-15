package equation;

import java.util.ArrayList;

import javax.lang.model.util.ElementScanner6;

import solution.ImaginarySolution;
import solution.RealSolution;
import solution.Solution;
import solution.RealSolution;;



public class QuadraticEquation extends PolynomialEquation {

	

	public QuadraticEquation(ArrayList<Term> terms) {
		super(terms);
		
	}

	@Override
	public ArrayList<Solution> solve() {
		double sqrt, q, pos1, pos2, pos3;
		double disc, coEff;
		int eqLen, pow;
		int[] Index = {-1, -1, -1};
		ConstantTerm conTerm;
		char var = 0;
		ArrayList<Solution> sol = new ArrayList<>();

		ArrayList<VariableTerm> varTerm = getVTerms();
		eqLen = varTerm.size();

		conTerm = getConstant();
		coEff = conTerm.getCoefficient();

		for(int i = 0; i< eqLen; i++){
			pow = varTerm.get(i).getPower();
			if(pow == 2){
				Index[0] = i;
				var = varTerm.get(i).getVar();
			}
			if(pow == 1) Index[1] = i;
			
		}

		pos1 = varTerm.get(Index[0]).getCoefficient();
		if(Index[1] == -1){
			pos2 = 0;
		}else{
			pos2 = varTerm.get(Index[1]).getCoefficient();
		}
		
		pos3 = coEff;

		double a = pos1;
		double b = pos2;
		double c = pos3;

		disc = (b*b)-(4*a*c);

		if(disc > 0){
			double sol1 = (-b + Math.sqrt((b*b)-(4*a*c)))/2*a ;
			double sol2 = (-b - Math.sqrt((b*b)-(4*a*c)))/2*a ;

			sol.add(new RealSolution(var, sol1));
			sol.add(new RealSolution(var, sol2));
		
		}else if(disc == 0){
			double soln = (-b + Math.sqrt((b*b)-(4*a*c)))/2*a ;

			sol.add(new RealSolution(var, soln));
		}else{
			sol.add(new ImaginarySolution());
		}


		return sol;
	}
	
	

}
