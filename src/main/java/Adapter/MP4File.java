package Adapter;

public class MP4File implements CodedFile{

    @Override
    public void decode(){
        System.out.println("Decodificando archivo MP4...");
    }

    @Override
    public int[] retrieveAudioData(){
        System.out.println("Obteniendo arreglo de datos del audio del archivo de video MP4...");
        return new int[5];
    }
}
