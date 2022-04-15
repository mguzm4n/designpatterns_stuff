import Adapter.*;
import Strategy.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Adapter

        MP3File mp3file = new MP3File();
        WAVFile wavfile = new WAVFile(new int[10], 50);

        System.out.println("Se entrega al cliente una clase compatible, el caso sin problemas...");
        adapterClient(wavfile); // Caso con clase compatible


        System.out.println("Se entrega al cliente una clase incompatible adaptándola correctamente...");
        adapterClient(new MP3WAVAdapter(mp3file));




//         Strategy
//        strategyTest();

    }
    static void adapterClient(DecodedFile file){
        System.out.println("Trabajo desde el cliente con una clase compatible...");
        file.getData();
        file.getSampleRate();
    }

    static void strategyTest(){
        MatrixUtils utils = new MatrixUtils();

        double[][] M = {{3, 8, 1},
                {1, 5, 0},
                {9, 1, 2}};

        utils.print(M);

        System.out.println("Método Crout");

        // Matriz U tiene su diagonal con 1's.
        FactorizationStrategy croutStrgy = new CroutStrategy();
        utils.setFactorizationStrategy(croutStrgy);

        List<double[][]> croutFact = utils.factorization(M);
        utils.print(croutFact.get(0));
        utils.print(croutFact.get(1));

        System.out.println("Método Doolittle");

        // Matriz L tiene  un 1 en la diagonal.
        FactorizationStrategy doolittleStrgy = new DoolittleStrategy();
        utils.setFactorizationStrategy(doolittleStrgy);

        List<double[][]> doolittleFact = utils.factorization(M);
        utils.print(doolittleFact.get(0));
        utils.print(doolittleFact.get(1));

        FactorizationStrategy gsStrgy = new GramSchmidtStrategy();
        utils.setFactorizationStrategy(gsStrgy);

        List<double[][]> gsFact = utils.factorization(M);
        utils.print(gsFact.get(0));
        utils.print(gsFact.get(1));
    }

}
