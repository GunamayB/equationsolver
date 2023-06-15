package input;
import java.util.*;

import equation.Term;
public abstract class PostValidator{

   

	public abstract boolean isValid(ArrayList<Term>terms);
	
    public int checkDegree(String eq){
        char[] exp = eq.toCharArray();
        int degree=0;
        boolean lessthan2=true;
        
        for(int i=0;i<exp.length;i++){
            if(exp[i]=='^'){
                lessthan2=false;
                break;
            }
        }
        
        if(lessthan2) {
        	for(int i=0;i<exp.length;i++) {
        		if(Character.toString(exp[i]).matches("[A-Za-z]")){
        			degree=1;
        			break;
        		}
        	}
        }
        
        if(!lessthan2) {
        	for(int i=0;i<exp.length-1;i++) {
        		if(exp[i]=='^') {
                    int num=Character.getNumericValue(exp[i+1]);
                    int j=i+2;
                    while (j<exp.length && Character.toString(exp[j]).matches("[0-9]")){
                        num*=10;
                        num+=Character.getNumericValue(exp[j]);
                        j++;
                    }
                    degree=Math.max(degree,num);
        		}
        	}
        }
        
        return degree;
    }
	
//	public int checkDegree(ArrayList<Term>terms) {
//		int result = 0;
//		for(Term t: terms) {
//			result = Math.max(t.getPower(), result);
//		}
//		return result;
//	}
    
        //post validator only linear has multiple varibales quadratic and cubic dont
        public boolean checkVariables(String eq){
            char[] exp = eq.toCharArray();
            int degree=checkDegree(eq);
            HashMap<Character, Integer> variables = new HashMap<Character, Integer>();
            
            for(int i=0;i<exp.length;i++){
                if(Character.toString(exp[i]).matches("[A-Za-z]")){
                    if (variables.containsKey(exp[i])){
                        int num=variables.get(exp[i]);
                        variables.replace(exp[i], num+=1);
                    } else{
                        variables.put(exp[i], 0);
                }
                }
            }

            if(variables.size()>1 && degree>1){
                return false;
            }

            return true;
        }
        
        public String arrayToString(ArrayList<Term>terms) {
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



        //postchecking
   /* public boolean checkNumberofEqs(String[] exp){//number of eqs< number of variables infinite solutions
        int eqs=0;
        HashMap<Character, Integer> variables = new HashMap<Character, Integer>();
       
        for (int i=0;i<exp.length;i++){
            eqs++;
            for (int j=0;j<exp[i].length();j++){
                if (Character.toString(exp[i].charAt(j)).matches("[A-Za-z]")){
                    if (variables.containsKey(exp[i].charAt(j))){
                        int num=variables.get(exp[i].charAt(j));
                        variables.replace(exp[i].charAt(j), num+=1);
                    } else{
                        variables.put(exp[i].charAt(j), 0);
                }
            }
        }
    }
        if (eqs==variables.size()){
            return true;
        }
        return false;
    }*/
}