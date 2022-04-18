import AbstractFactory.AbstractDeviceFactory;
import AbstractFactory.Headphones;
import AbstractFactory.Speaker;
import AbstractFactory.WirelessDeviceFactory;
import Adapter.*;
import Command.ElementaryMatrixCalculator;
import Command.RenderMatrixEngine;
import Command.SwapCommand;
import Strategy.*;
import AbstractFactory.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Abstract Factory.

        AbstractDeviceFactory wirelessDeviceFactory = new WirelessDeviceFactory();
        Headphones headphones = wirelessDeviceFactory.createHeadphones();
        Keyboard keyboard = wirelessDeviceFactory.createKeyboard();
        Speaker speaker = wirelessDeviceFactory.createSpeaker();


        // Adapter

        MP3File mp3file = new MP3File();
        WAVFile wavfile = new WAVFile(new int[10], 50);

        System.out.println("Se entrega al cliente una clase compatible, el caso sin problemas...");
        adapterClient(wavfile); // Caso con clase compatible

        System.out.println("Se entrega al cliente una clase incompatible adaptándola correctamente...");
        adapterClient(new MP3WAVAdapter(mp3file));

//         Strategy
//        strategyTest();

        commandTest();

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

    /**
     * Los comandos pueden servir, ahora, individualmente, para:
     * - Resolver sistema de ecuaciones.
     * - Obtener la matriz inversa.
     * - Reducir la matriz como matriz triangular superior o inferior.
     * - Reducir la matriz en forma escalonada.
     */
    static void commandTest(){
        // Estado de nustra app
        int[][] M = {{1, 2, 1},
                {1, 3, 2},
                {2, 4, 5}};

        // Obtengamos la forma triangular superior:

        var btn = new RenderMatrixEngine();

        // Emisor de solicitudes o comandos
        var calculator = new ElementaryMatrixCalculator();

        // Crear un comando individual
        SwapCommand swpCmd = new SwapCommand(1, 2, M);

        swpCmd.setReceiver(btn); // Pasar objeto receptor
        calculator.setCommand(swpCmd);
        calculator.executeCommand();

    }
}
