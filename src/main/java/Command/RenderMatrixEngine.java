package Command;

/**
 * Receiver o clase receptora
 */
public class RenderMatrixEngine {
    int[][] matrix;

    public void render(int[][] matrix){
        this.matrix = matrix;
        int n = this.matrix[0].length;

        System.out.println("Como receptor, recibo el parámetro del emisor para operarlo...");
        System.out.println("Realizando operaciones en la GUI para renderizar la matrix en pantalla...");
        for (int i = 0; i < n; i++) {
            System.out.print("[ ");
            for (int j = 0; j < n; j++) {
                System.out.print(this.matrix[i][j]);
                if( j != n - 1 ){
                    System.out.print(", ");
                }
            }
            System.out.println(" ]");
        }
    }
    public void update(){
        System.out.println("Actualizar la GUI...");
        this.render(this.matrix);
    }
}
