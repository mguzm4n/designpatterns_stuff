package Command;

public class SwapCommand implements RowOperationCommand {
    int row_i, row_j;
    int[][] matrix;

    /**
     * Deja los valores de la fila i en la fila j y viceversa.
     * @param i
     * @param j
     * @param matrix
     */
    public SwapCommand(int i, int j, int[][] matrix){
        this.matrix = matrix;
        this.row_i = i - 1;
        this.row_j = j - 1;
    }
    @Override
    public int[][] execute() {

        int n = matrix[0].length;
        int[] copy = new int[n];
        System.arraycopy(matrix[this.row_i], 0, copy, 0, n);

        for (int i = 0; i < n; i++) {
            matrix[this.row_i][i] = matrix[this.row_j][i];
            matrix[this.row_j][i] = copy[i];
        }

        return matrix;
    }

}
