package Command;

public class AddMultiplicationCommand extends RowOperationCommand {
    int row_i, row_j, factor;

    /**
     * La fila i se convierte en la fila i + k veces la fila j.
     * @param i
     * @param k
     * @param j
     * @param matrix
     */
    public AddMultiplicationCommand(int i, int k, int j, int[][] matrix){
        this.row_i = i;
        this.row_j = j;
        this.factor = k;
        this.matrix = matrix;
    }

    @Override
    public int[][] execute() {
        MultiplicationCommand multCommand = new MultiplicationCommand(this.row_j, this.factor, this.matrix);
        var mult = multCommand.execute();
        AddCommand addCommand = new AddCommand(row_i, row_j, mult);
        var finalMatrix = addCommand.execute();

        this.matrix = finalMatrix;

        this.gui.render(finalMatrix);

        return finalMatrix;
    }
}
