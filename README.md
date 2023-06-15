# Equation Solver

FLOW  
User input
- break the input string to lhs string and rhs string (waleed/mutasim)
Validation of equation (checking brackets, equal)
- sending rhs string to lhs string (concate)
Simplify (using one string to store and update the equation)
Method: finding the first ')' 
- removing brackets 
- getting standardized form
Solving for the roots

calc - Yash 
to finish -3x+2x, 3x^2-2x^2

multi func - shrivatsa
- 3+(x+1)
- 3(x-2)+1
- (x+2)3+1
- (x+2)(x-3)
- (x-1)(x-3)(x+2)


Input Conditions:
- no '/' in the input
- 

Term -> coefficient, var and power 
Equation -> ArrayList<Term>

ArrayList<Equation>
Equation -> 2 Arraylist - one variables and one constant

Simplify-> String calculate(ArrayList<String> terms) NEEDS TO BE CHECKED

Bugs in Simplify:

1. correctPower: split("+") instead of split("\\+")
    crashes
2. simplifyTerms: split("*") instead of split("\\*")
crashes
3. getCoefficient: Wrote: if(x>='0'&& x=='.' && x<='9')
    should have been: if((x>='0' && x<='9')|| x=='.')
    does not take the decimal part of the coefficient
4. getVar could not handle signs, modified it to be able to do so
    if a term is +45x then it returned empty string
5. getCoefficient could not handle signs, modified it to be able to do so
    returned empty string if a term had a sign (eg -45x or +45x)
6. splitIntoTerms did not give the last term in the expression, fixed it
7. removeConstantPower is not working (does not do anything)
8. calc: 
     fin = '+'+sum; so the ascii code of '+' was getting added to sum
9. splitIntoTerms :
    sign = newsign was not added in the catch block, thus it could not handle - signs
    only added terms irrespective of the sign of the term in the inputted string
10. multiply:
    ArrayIndexOutOfBoundsException, wrote i instead of j in termsb[1].get
11. rearrange:
    constant terms are not getting removed from the variable array
    term.remove(indices.get(i)) does not remove the required term for some reason
12. correctPower: does not handle signs
     if 


Problems left to solve:
1. removeConstantPower is not working
•	Empty String in main
•	Empty String in Simultaneous
•	Simultaneous equations variable and no of equations thing (first equation)
•	Remove some singleton classes
Yash's code case with 1 variable
{1
2x+2=0
done}

Shuai's code still has problems:
(x-2)(x-2)(x+3)