
package equation;

import java.util.ArrayList;
import java.math.BigDecimal;
import java.math.RoundingMode;
import solution.RealSolution;
import solution.Solution;

public class CubicEquation extends PolynomialEquation {
	

	public CubicEquation(ArrayList<Term> terms) {
		super(terms);
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Solution> solve() {
		int sizeOfEq = 0;
		int[] index = { -1, -1, -1, -1 };
		double m, n, t, s;
		ConstantTerm cc;
		double cCo;

		ArrayList<Solution> solutions = new ArrayList<>();

		ArrayList<VariableTerm> VTerms = getVTerms();
		sizeOfEq = VTerms.size();

		cc = getConstant();
		cCo = cc.getCoefficient();
		char var = 0;

		for (int i = 0; i < sizeOfEq; i++) {
			int power = VTerms.get(i).getPower();
			if (power == 3) {
				index[0] = i;
				var = VTerms.get(i).getVar();
			}
			if (power == 2)
				index[1] = i;
			if (power == 1)
				index[2] = i;

		}

		m = VTerms.get(index[0]).getCoefficient();
		if (index[1] == -1)
			n = 0;
		else
			n = VTerms.get(index[1]).getCoefficient();
		if (index[2] == -1)
			t = 0;
		else
			t = VTerms.get(index[2]).getCoefficient();
		s = cCo;

		double a = n / m;
		double b = t / m;
		double c = s / m;
		double q = (a * a - 3 * b) / 9;
		double truncatedQ=BigDecimal.valueOf(q*q*q)
				    .setScale(10, RoundingMode.HALF_UP)
				    .doubleValue();
		double r = (2 * a * a * a - 9 * a * b + 27 * c) / 54;
		double truncatedR=BigDecimal.valueOf(r*r)
				    .setScale(10, RoundingMode.HALF_UP)
				    .doubleValue();
		
		if (truncatedR<=truncatedQ) {
			t = Math.acos(r / Math.sqrt(q * q * q));
			double x1 = -2 * Math.sqrt(q) * Math.cos(t / 3) - a / 3;
			double x2 = -2 * Math.sqrt(q) * Math.cos((t + 2 * Math.PI) / 3) - a / 3;
			double x3 = -2 * Math.sqrt(q) * Math.cos((t - 2 * Math.PI) / 3) - a / 3;
			solutions.add(new RealSolution(var, x1));
			solutions.add(new RealSolution(var, x2));
			solutions.add(new RealSolution(var, x3));
		} else {
			int sgn = (r >= 0) ? 1 : -1;
			double u = -sgn * Math.pow((Math.abs(r) + Math.sqrt(r * r - q * q * q)), 1. / 3);
			double v = (u != 0) ? q / u : 0;
			double x1 = u + v - a / 3;
			solutions.add(new RealSolution(var, x1));
		}
		
		return solutions;

	}

}
