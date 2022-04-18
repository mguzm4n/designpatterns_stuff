package AbstractFactory;

public interface AbstractDeviceFactory {
    public Keyboard createKeyboard();
    public Speaker createSpeaker();
    public Headphones createHeadphones();
}
