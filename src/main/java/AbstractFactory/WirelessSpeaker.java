package AbstractFactory;

public class WirelessSpeaker implements Speaker {

    @Override
    public void nextStream() {
        System.out.println("PARLANTE INALÁMBRICO: poner siguiente canción...");
    }

    @Override
    public void prevStream() {
        System.out.println("PARLANTE INALÁMBRICO: poner canción anterior...");
    }

    @Override
    public void setVolume(int i) {
        System.out.println("PARLANTE INALÁMBRICO: Subiendo volumen en " + Integer.toString(i) + " unidades");
    }

    @Override
    public void connect() {
        System.out.println("PARLANTE INALÁMBRICO: conectándose a dispositivo inalábricamente...");
    }
}
