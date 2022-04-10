import Adapter.*;
import Strategy.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        MP3File mp3f = new MP3File();
//        MP3Adapter mp3adapter = new MP3Adapter(mp3f);
//
//        // mp3adapter ahora transforma la interface
//        // de 'CodedFile' en un 'AudioFile' y por ello
//        // podemos usar sus métodos.
//
//        mp3adapter.computeDuration();
//        mp3adapter.performFFT();

        // Strategy
        MatrixUtils utils = new MatrixUtils();

        double[][] M = {{3, 8, 1},
                     {1, 5, 0},
                     {9, 1, 2}};

        utils.print(M);

        // Matriz U tiene su diagonal con 1's.
        FactorizationStrategy croutStrgy = new CroutStrategy();

        utils.setFactorizationStrategy(croutStrgy);
        List<double[][]> croutFact = utils.factorization(M);
        utils.print(croutFact.get(0));
        utils.print(croutFact.get(1));
        // ---





    }
}
