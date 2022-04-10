package Strategy;

import java.util.ArrayList;
import java.util.List;

public class CroutStrategy implements FactorizationStrategy {
    double[][] L, U;

    @Override
    public void execute(double[][] A){

        int cols = A[0].length;
        int rows = A.length;

        double[][] L = new double[rows][cols];
        double[][] U = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                U[i][j] = i == j? 1 : 0.0;
                L[i][j] = 0.0;
            }
        }

        for (int j = 0; j < cols; j++) {
            for (int i = j; i < cols; i++) {
                double sum = 0.0;
                for (int k = 0; k < j; k++) {
                    sum = sum + L[i][k] * U[k][j];
                }
                L[i][j] = A[i][j] - sum;
            }

            for (int i = j; i < cols; i++) {
                double sum = 0.0;
                for (int k = 0; k < j; k++) {
                    sum = sum + L[j][k] * U[k][i];
                }
                if (L[j][j] == 0) {
                    return;
                }
                U[j][i] = (A[j][i] - sum) / L[j][j];
            }
        }

        this.L = L;
        this.U = U;

    }

    @Override
    public List<double[][]> getResults() {
        return List.of(L, U);
    }

}

