package Command;

public abstract class RowOperationCommand {
    RenderMatrixEngine buttonReceiver;
    int[][] matrix;

    abstract int[][] execute();

    public void setReceiver(RenderMatrixEngine btn){
        this.buttonReceiver = btn;
    }
}
