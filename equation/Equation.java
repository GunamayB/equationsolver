package equation;
import java.util.*;
public abstract class Equation {
    // class for breaking down the equation

    private ArrayList<Term> terms;

    public Equation(ArrayList<Term> terms){
        this.terms=terms;
    }
    
    public String toString() {
		String result ="";
		for(int i=0;i<terms.size();i++) {
			String term = terms.get(i).toString();
			if(term.charAt(0)!='+'&&term.charAt(0)!='-') {
				result+="+"+term;
			}
			else {
				result+=term;
			}
		}
		result=result.substring(1);
		return result;
	
    }
    
    public ConstantTerm getConstant() {
    	for(Term term:terms) {
    		if(term instanceof ConstantTerm ) {
    			return (ConstantTerm) term;
    		}
    	}
    	return new ConstantTerm("0.0");
    }
    
    public ArrayList<VariableTerm> getVTerms(){
    	ArrayList<VariableTerm>result = new ArrayList<>();
    	for(Term term:terms) {
    		if(term instanceof VariableTerm ) {
    			result.add( (VariableTerm) term);
    		}
    	}
    	return result;
    }
    
 
    
}