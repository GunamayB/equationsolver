package input;
import java.util.*;

import equation.Term;

public class quadraticPostValidator extends PostValidator{

    private static quadraticPostValidator instance = new quadraticPostValidator();

	public static quadraticPostValidator getInstance() {
		return instance;
    }

    public boolean isValid(ArrayList<Term>terms){
    	String exp = arrayToString(terms);
        if(checkDegree(exp)!=2){
            System.out.println("Equation is not a Quadratic one");
            return false;
        }

        if(!checkVariables(exp)){
            System.out.println("More than one variable in equation");
            return false;
        }
        return true;
    }
}