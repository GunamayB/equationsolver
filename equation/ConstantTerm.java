package equation;

public class ConstantTerm extends Term {
	
	public ConstantTerm(String cons) {
		super(cons);
	}
	
	public String toString() {
		return Double.toString(getCoefficient());
	}
}
