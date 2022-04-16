package Command;

public class AddCommand implements RowOperationCommand {
    int[][] matrix;
    int row_i, row_j;

    /**
     * Asignar a la fila i la suma elemento a elemento de la fila i y fila j
     * @param i Fila a reemplazar
     * @param j Fila a ser sumada con la fila i (no se modifica fila j)
     * @param matrix Matriz a ser evaluada
     */
    public AddCommand(int i, int j, int[][] matrix){
        this.matrix = matrix;
        this.row_i = i - 1;
        this.row_j = j - 1;
    }

    @Override
    public int[][] execute() {
        int n = matrix[0].length;
        for(int i = 0; i < n; i++){
            matrix[this.row_i][i] += matrix[this.row_j][i];
        }

        return matrix;
    }
}
