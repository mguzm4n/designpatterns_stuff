package Strategy;

import java.util.List;

public class MatrixUtils {
    FactorizationStrategy factorizationStrategy;

    public void print(double[][] A){
        System.out.println("***");
        for (int i = 0; i < 3; i++){
            System.out.print("[");
            for (int j = 0; j < 3; j++) {
                System.out.print(A[i][j]);
                System.out.print(", ");
            }
            System.out.print("]");
            System.out.println("\n");
        }
        System.out.println("***");
    }

    public void print(int[][] A){
        System.out.println("***");
        for (int i = 0; i < 3; i++){
            System.out.print("[");
            for (int j = 0; j < 3; j++) {
                System.out.print(A[i][j]);
                System.out.print(", ");
            }
            System.out.print("]");
            System.out.println("\n");
        }
        System.out.println("***");
    }

    public double[][] copy(double[][] A){
        double[][] B = new double[A.length][];
        for(int i = 0; i < A.length; i++){
            B[i] = new double[A[i].length];
            System.arraycopy(A[i], 0, B[i], 0, A[i].length);
        }

        return B;
    }

    public double[][] zeros(int n, int m){
        double[][] A = new double[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                A[i][j] = 0;
            }
        }
        return A;
    }

    public List<double[][]> factorization(double[][] A){
        factorizationStrategy.execute(A);
        return factorizationStrategy.getResults();
    }

    public void setFactorizationStrategy(FactorizationStrategy strategy){
        this.factorizationStrategy = strategy;
    }
}
