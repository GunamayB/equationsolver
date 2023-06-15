package equation;
public class VariableTerm extends Term {
    
    
    private char var;
    private int power;
    
    public VariableTerm() {};

    public VariableTerm(String term){
        String coef = "";
        for(int i =0;i<term.length();i++){
            char x=term.charAt(i);
            if(!((x>='a' && x<='z')||(x>='A'&&x<='Z'))){
                coef+=x;
            }
            else{
            	if(coef.length()==0) {
            		coef="1";
            	}
            	else if((coef.charAt(0)=='+'&&coef.length()==1)) {
            		coef = "1";
            	}
            	else if(coef.charAt(0)=='-'&&coef.length()==1) {
            		coef="-1";
            	}
                var = x;
                String exp = term.substring(i);
                if(exp.length()==1)
                    power = 1;
                else
                    power = Integer.parseInt(exp.substring(exp.length()-1));
                setCoefficient(Double.parseDouble(coef));
            }
        }

    }

    

    public int getPower(){
        return this.power;
    }

    public char getVar(){
        return this.var;
    }


    public String toString(){
    	String term;
    	if(this.getPower()>1) 
    		term = Double.toString(this.getCoefficient())+this.var+"^"+this.power;
    	else
    		term=Double.toString(this.getCoefficient())+this.var+"";
        return term;
    }

}
