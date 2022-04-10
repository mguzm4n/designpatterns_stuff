package Strategy;

import java.util.List;

public class MatrixUtils {
    FactorizationStrategy factorizationStrategy;

    public void print(double[][] A){
        for (int i = 0; i < 3; i++){
            System.out.print("[");
            for (int j = 0; j < 3; j++) {
                System.out.print(A[i][j]);
                System.out.print(", ");
            }
            System.out.print("]");
            System.out.println("\n");
        }
    }
    public double[][] copy(double[][] A){
        double[][] B = new double[A.length][];
        for(int i = 0; i < A.length; i++){
            B[i] = new double[A[i].length];
            System.arraycopy(A[i], 0, B[i], 0, A[i].length);
        }

        return B;
    }

    public List<double[][]> factorization(double[][] A){
        factorizationStrategy.execute(A);
        return factorizationStrategy.getResults();
    }

    public void setFactorizationStrategy(FactorizationStrategy strategy){
        this.factorizationStrategy = strategy;
    }
}