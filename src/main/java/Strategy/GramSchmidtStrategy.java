package Strategy;

import java.util.List;

public class GramSchmidtStrategy implements FactorizationStrategy{
    double[][] Q, R;

    @Override
    public void execute(double[][] A) {
        int cols = A[0].length;
        int rows = A.length;
        
        MatrixUtils utils = new MatrixUtils();

        double[][] Q = utils.copy(A);
        double[][] R = utils.zeros(rows, cols);

        double dotprod, norm;
        for (int k = 0; k < rows; k++) {
            for (int i = 0; i < k; i++) {

                dotprod = 0;
                for (int s = 0; s < rows; s++) {
                    dotprod += Q[s][i]*Q[s][k];
                }
                R[i][k] = dotprod;

                for (int s = 0; s < rows; s++) {
                    Q[s][k] = Q[s][k] - Q[s][i]*R[i][k];
                }

            }

            norm = 0;
            for (int s = 0; s < rows; s++) {
                norm += Q[s][k]*Q[s][k];
            }
            R[k][k] = Math.sqrt(norm);

            for (int s = 0; s < rows; s++) {
                Q[s][k] = (Q[s][k]/R[k][k]);
            }

        }

        this.Q = Q;
        this.R = R;

    }

    public List<double[][]> getResults() {
        return List.of(Q, R);
    }

    public double[][] getQ() {
        return Q;
    }

    public double[][] getR() {
        return R;
    }
}
