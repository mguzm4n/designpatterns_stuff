package Command;

public abstract class RowOperationCommand {
    RenderMatrixEngine gui;
    int[][] matrix;

    abstract int[][] execute();

    public void setReceiver(RenderMatrixEngine gui){
        this.gui = gui;
    }
}
