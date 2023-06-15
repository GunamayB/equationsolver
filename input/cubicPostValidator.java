package input;
import java.util.*;

import equation.Term;

public class cubicPostValidator extends PostValidator{

    private static cubicPostValidator instance = new cubicPostValidator();

	public static cubicPostValidator getInstance() {
		return instance;
    }

    public boolean isValid(ArrayList<Term>terms){
    	String exp = arrayToString(terms);
        if(checkDegree(exp)!=3){
            System.out.println("Equation is not a Cubic one");
            return false;
        }

        if(!checkVariables(exp)){
            System.out.println("More than one variable in equation");
            return false;
        }
        return true;
    }
}
