package AbstractFactory;

public class WirelessKeyboard implements Keyboard{
    @Override
    public char write(char c) {
        System.out.println("TECLADO INALÁMBRICO: Se escribe la letra: " + c);
        return 0;
    }

    @Override
    public void delete() {
        System.out.println("Eliminando la última letra...");
    }
}
