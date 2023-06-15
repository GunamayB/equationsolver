package equation;

import java.util.ArrayList;

import solution.RealSolution;
import solution.Solution;

public class SimultaneousEquation {
    
    ArrayList<LinearEquation> eqs;
    double originalMatrix[][];
    double constMatrix[][];
    int n;
    
    public SimultaneousEquation (ArrayList<LinearEquation> equations) { 
        eqs = equations;
    }

    public void setMatrix () {
        // initialise the matrix from getting data from eqs
        n = eqs.size();
        
        originalMatrix = new double[n][n];
        constMatrix  = new double[n][1];
        
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                originalMatrix[i][j] = eqs.get(i).getVTerms().get(j).getCoefficient();  //need to check
        
        for (int i=0;i<n;i++) {
            constMatrix[i][0] = eqs.get(i).getConstant().getCoefficient();
        }
        
    }

    public ArrayList<Solution> solve() {
    	
    	ArrayList<Solution> answer = new ArrayList<>();
    	
    	
    	setMatrix();
    	double[][] result = new double[n][1]; 
    	double inverseMatrix[][] = inverse(originalMatrix);
        // multiplying 2 matrices    
        for(int i = 0; i < n; i++) {
            for(int j = 0;j < 1; j++) {    
           
                result[i][j] = 0;     
                
                for(int k = 0; k < n; k++) {      
                    result[i][j] += inverseMatrix[i][k] * constMatrix[k][j];

                } 
            } 
        }
        
        for (int i = 0; i < n; i++) {
        	answer.add(new RealSolution(eqs.get(0).getVTerms().get(i).getVar(), -1*result[i][0]));
        }
        
        return answer;

    }

    public double[][] inverse(double originalMatrix[][]) 
    {
        int n = originalMatrix.length;
        double invert[][] = new double[n][n];
        double b[][] = new double[n][n];
        int index[] = new int[n];
        for (int i = 0; i < n; ++i) 
            b[i][i] = 1;
 
        // Transform the matrix into an upper triangle
        gaussian(originalMatrix, index);
 
        for (int i = 0; i < n - 1; ++i)
            for (int j = i + 1; j < n; ++j)
                for (int k = 0; k < n; ++k)
                    b[index[j]][k] -= originalMatrix[index[j]][i] * b[index[i]][k];
 
        // Perform backward substitutions
        for (int i = 0; i < n; i++) 
        {
            invert[n-1][i] = b[index[n-1]][i] / originalMatrix[index[n-1]][n-1];
            for (int j = n - 2; j >= 0; --j) 
            {
                invert[j][i] = b[index[j]][i];
                for (int k = j+1; k < n; ++k) 
                {
                    invert[j][i] -= originalMatrix[index[j]][k] * invert[k][i];
                }
                invert[j][i] /= originalMatrix[index[j]][j];
            }
        }
        return invert;
    }
 
    public void gaussian(double originalMatrix[][], int index[]) 
    {
        int n = index.length;
        double gauMatrix[] = new double[n];
 
        // Initialise the index
        for (int i = 0; i < n; ++i) 
            index[i] = i;
 
        for (int i = 0; i < n; ++i) 
        {
            double element1 = 0;
            for (int j = 0; j < n; ++j) 
            {
                double element0 = Math.abs(originalMatrix[i][j]);
                if (element1 < element0) 
                	element1 = element0;
            }
            gauMatrix[i] = element1;
        }
 
        int k = 0;
        for (int j = 0; j < n - 1; ++j) 
        {
            double pivot1 = 0;
            for (int i = j; i < n; ++i) 
            {
                double pivot0 = Math.abs(originalMatrix[index[i]][j]);
                pivot0 /= gauMatrix[index[i]];
                if (pivot0 > pivot1) 
                {
                    pivot1 = pivot0;
                    k = i;
                }
            }
 
            // Interchange rows according to the pivoting order
            int temp = index[j];
            index[j] = index[k];
            index[k] = temp;
            for (int i = j + 1; i < n; ++i) 	
            {
                double pivot = originalMatrix[index[i]][j] / originalMatrix[index[j]][j];
 
            // Record pivoting ratios below the diagonal
                originalMatrix[index[i]][j] = pivot;
 
                // Modify other elements accordingly
                for(int l = j + 1; l < n; ++l)
                    originalMatrix[index[i]][l] -= pivot * originalMatrix[index[j]][l];
            }
        }
    }

    public double[][] getOriginalMatrix() {
        return this.originalMatrix;
    }

    public double[][] getConstantMatrix() {
        return this.constMatrix;
    }
    
    public ArrayList<LinearEquation> getEquations(){
    	return this.eqs;
    }
}