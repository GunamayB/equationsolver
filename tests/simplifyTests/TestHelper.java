package tests.simplifyTests;

import java.util.ArrayList;

public class TestHelper {
	public static String ListToString(ArrayList<String>[] terms) {
		String result ="";
		for(int i=0;i<terms[1].size();i++) {
			char x = terms[1].get(i).charAt(0);
			if(x=='-'||x=='+') {
				result+=terms[1].get(i);
			}
			else
				result+="+"+terms[1].get(i);
		}
		for(int i=0;i<terms[0].size();i++) {
			char x = terms[0].get(i).charAt(0);
			if(x=='-'||x=='+') {
				result+=terms[0].get(i);
			}
			else
				result+="+"+terms[0].get(i);
		}
		return result;
	}

}
