package equation;

public abstract class Term {
	private double coefficient;
	
	public Term() {};
	
	public Term(String coef) {
		this.coefficient=Double.parseDouble(coef);
	}
	
	public void setCoefficient(double c) {
        this.coefficient = c;
    }
	
	public double getCoefficient() {
        return this.coefficient;
    }
	
	public abstract String toString();
}
