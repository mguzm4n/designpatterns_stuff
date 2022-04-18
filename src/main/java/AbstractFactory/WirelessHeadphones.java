package AbstractFactory;

public class WirelessHeadphones implements Headphones{

    @Override
    public void startStream() {
        System.out.println("AUDIFONO INALÁMBRICO: cambiando canción...");

    }

    @Override
    public void setVolume(int i) {
        System.out.println("AUDIFONO INALÁMBRICO: Subiendo volumen en " + Integer.toString(i) + " unidades");

    }

    @Override
    public void connect() {
        System.out.println("AUDIFONO INALÁMBRICO: Conectándome inalámbricamente...");
    }
}
