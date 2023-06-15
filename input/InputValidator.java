package input;

import java.nio.file.FileSystemLoopException;
import java.util.ArrayList;
import java.util.Stack;
import java.util.HashMap;

public class InputValidator{
private static InputValidator instance = new InputValidator();

	
	public static InputValidator getInstance() {
		return instance;
		
    }
    
    public boolean isValid(String e) {
            String[] exp = e.split("");
            if(!checkVariable(exp)){
         
                return false;
            }
            if(!checkInvalidChars(exp)){
            
                return false;
            }
            if (!bracketsValid(exp)) {
            	
                return false;
            }
            if(!operatorsValid(exp)){
            	
                return false;
            }
            if (!checkDecimal(exp)) {
            	System.out.println("");
                return false;
            }
            if(!checkAfterBrackets(exp)){
            	System.out.println("");
                return false;
            }
            if(!checkAfterVariable(exp)){
            	System.out.println("");
                return false;
            }
            if (!checkConstantPowers(exp)) {
            	System.out.println("");
                return false;
            }
            if(!checkPowers(exp)){
            	System.out.println("");
                return false;
            }
        return true;
    }

    public boolean operatorsValid(String[] exp) {
        if(exp[0].matches("[*^]+")||exp[exp.length-1].matches("[+\\-*/^]+")){
            return false;
        }
        for(int i = 1 ; i<exp.length-1; i++){
            if(exp[i].equals("+")||exp[i].equals("-")){
                if(!exp[i+1].matches("[A-Za-z0-9({\\[]+")){
                    return false;
                }
                if(!exp[i-1].matches("[A-Za-z0-9)\\]}({\\[]+")){  
                    return false;
                }  
            }
        }
        return true;
    }

    public boolean bracketsValid(String[] exp) {
        Stack<String> stack = new Stack<>() ; 
        for (String e : exp) {
            if (e.matches("[({\\[]+")) {
                stack.push(e);
            } else if (e.equals(")")) {
            	if(stack.isEmpty()) {
            		return false;
            	}
                if(stack.peek().equals("(")) {
                	stack.pop();
                }else {
                	return false;
                }
                	
            }else if(e.equals("}")) {
            	if(stack.isEmpty()) {
            		return false;
            	}
            	if(stack.peek().equals("{")) {
                	stack.pop();
                }else {
                	return false;
                }
            	
            }else if(e.equals("]")) {
            	if(stack.isEmpty()) {
            		return false;
            	}
            	if(stack.peek().equals("[")) {
                	stack.pop();
                }else {
                	return false;
                }
            }
        }
        if (!stack.empty()) {
            return false;
        }
        return true;
    }

    public boolean checkInvalidChars(String[] exp){
        for (int i=0;i<exp.length;i++){
        if (exp[i].matches("[A-Za-z0-9*^+()-.{}//[//]]")){
           continue; 
        } else{ 
            System.out.println(exp[i]+" is an Invalid Character");
            return false;
        }
    }
        return true;
    }


    public boolean checkDecimal(String[] exp){
    	for(int i=0;i<exp.length;i++){
            if (exp[i].equals(".") && i+1<exp.length && exp[i+1].matches("[+/*^*-]")){
                System.out.println("Invalid Decimal");
            	return false;
            }
            }
    	
        for(int i=0;i<exp.length;i++){
            if (exp[i].equals(".") && i+1<exp.length){
               for (int j=i+1;j<exp.length;j++){
                    if(exp[j].matches("[A-Za-z]")){
                        System.out.println("Invalid Decimal");
                        return false;
                    } else if(exp[j].matches("[+/*^*-]")){
                        break;
                    }
               } 
            }
        }
        return true;
    }

    public boolean checkConstantPowers(String[] exp){
        for (int i=1;i<exp.length;i++){
            if(exp[i].equals("^")){
                if(exp[i-1].matches("[0-9]")){
                    System.out.println("Numbers can not be raised to any power");
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean checkAfterVariable(String[] exp){
        for(int i=0;i<(exp.length-1);i++){
            if(exp[i].matches("[A-Za-z]")){
                if (exp[i+1].matches("[0-9]")){
                    System.out.println("Can not have a number after a variable");
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean checkAfterBrackets(String[] exp) {
    	for(int i=0;i<exp.length-1;i++){
            if (exp[i].equals("(") && exp[i+1].equals("^")){
                System.out.println("Can not raise brackets to a power");
                return false;
            } else if (exp[i].equals(")") && exp[i+1].equals("^")) {
                System.out.println("Can not raise brackets to a power");
            	return false;
            } 
    	}
    	return true;
    }
    
    public boolean checkPowers(String[] exp) {
    	for (int i=1;i<exp.length;i++){
            if(exp[i].equals("^") && exp[i+1].matches("[A-Za-z]")){
                System.out.println("Powers can not be variables");
            	return false;
            }
        }
        

    	return true;
    }

    public boolean checkEqualsToSign(String[] exp){
        if(exp[0].equals("=")){
            System.out.println("Equals To Sign can not be the first thing in the expression");
            return false;
        }

        if(exp[exp.length-1].equals("=")){
            System.out.println("Equals To Sign can not be the last thing in the expression");
            return false;
        }

        int count=0;
        for(int i=0;i<exp.length;i++){
            if(exp[i].equals("=")){
                count++;
            }
        }

        if(count!=1){
            System.out.println("There needs to be only one Equals To Sign");
            return false;
        }

        return true;
    }
    
    public boolean checkVariable(String[] exp) {
    	for (int i=0;i<exp.length;i++) {
    		if(exp[i].matches("[A-Za-z]")) {
    			return true;
    		}
    	}
       	System.out.println("There needs to be at least one variable in the equation");
    	return false;
    }
}


