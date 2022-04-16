package Command;

/**
 * Clase emisora o invocadora
 */
public class ElementaryMatrixCalculator {
    RowOperationCommand command;

    public void setCommand(RowOperationCommand command){
        this.command = command;
    }

    public void executeCommand(){
        this.command.execute();
    }
}
