package Adapter;

public class MP3Adapter implements AudioFile{
    CodedFile codedFile;

    public MP3Adapter(CodedFile codedFile){
        this.codedFile = codedFile;
    }

    @Override
    public void computeDuration() {
        this.codedFile.decode();
        // TO DO...
        System.out.println("Calculando la duración del audio dentro del archivo .mp3...");
    }

    @Override
    public void performFFT() {
        this.codedFile.decode();
        int[] data = this.codedFile.retrieveAudioData();
        // TO DO...
        System.out.println("Calculando la FFT del audio dentro del archivo .mp3...");
    }
}
