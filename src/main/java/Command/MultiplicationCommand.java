package Command;

public class MultiplicationCommand implements RowOperationCommand {
    int row_i;
    int factor;
    int[][] matrix;

    public MultiplicationCommand(int i, int factor, int[][] matrix){
        this.row_i = i - 1;
        this.factor = factor;
        this.matrix = matrix;
    }
    @Override
    public int[][] execute() {

        int n = matrix[0].length;
        for(int i = 0; i < n; i++){
            matrix[this.row_i][i] *= factor;
        }

        return matrix;
    }
}
