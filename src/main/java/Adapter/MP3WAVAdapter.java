package Adapter;

import java.util.Random;

public class MP3WAVAdapter implements DecodedFile{
    CodedFile codedFile;

    public MP3WAVAdapter(CodedFile file){
        this.codedFile = file;
    }

    @Override
    public int[] getData() {
        codedFile.decode();
        codedFile.retrieveAudioData();
        return new int[0];
    }

    @Override
    public int getSampleRate() {
        codedFile.retrieveAudioData();

        // código...

        int finalRate = new Random().nextInt();
        return finalRate;
    }
}
