package Adapter;

public class WAVFile implements DecodedFile {
    int[] data;
    int sampleRate;

    public WAVFile(int[] data, int sampleRate){
        this.data = data;
        this.sampleRate = sampleRate;
    }

    public int[] getData() {
        return data;
    }

    public int getSampleRate() {
        return sampleRate;
    }
}
