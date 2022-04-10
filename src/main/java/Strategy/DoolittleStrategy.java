package Strategy;

import java.util.List;

public class DoolittleStrategy implements FactorizationStrategy{
    double[][] L, U;

    @Override
    public void execute(double[][] A) {

        int cols = A[0].length;
        int rows = A.length;

        double[][] L = new double[rows][cols];
        double[][] U = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                L[i][j] = i == j ? 1 : 0;
                U[i][j] = i == j ? 1 : 0;
            }
        }

        double suma1, suma2, suma3;
        for (int k = 0; k < rows; k++) {
            suma1 = 0;
            for (int j = 0; j <= k - 1; j++) {
                suma1 = suma1 + L[k][j] * U[j][k];
            }
            U[k][k] = (A[k][k] - suma1);

            for (int i = k + 1; i < rows; i++) {
                suma2 = 0;
                for (int q = 0; q <= k - 1; q++) {
                    suma2 = suma2 + L[i][q] * U[q][k];
                }
                L[i][k] = (A[i][k] - suma2) / U[k][k];
            }
            for (int j = k + 1; j < rows; j++) {
                suma3 = 0;
                for (int s = 0; s <= k - 1; s++) {
                    suma3 = suma3 + L[k][s] * U[s][j];
                }
                U[k][j] = (A[k][j] - suma3);
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
