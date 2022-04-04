package Adapter;

public class MP3File implements CodedFile{

    @Override
    public void decode(){
        System.out.println("Decodificando archivo MP3...");
    }

    @Override
    public int[] retrieveAudioData(){
        System.out.println("Obteniendo arreglo de datos del audio del archivo MP3...");
        return new int[5];
    }
}
