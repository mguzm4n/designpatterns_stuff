package Adapter;

public interface CodedFile {
    void decode();
    int[] retrieveAudioData();
    int[][] getFileHeaders();
}
