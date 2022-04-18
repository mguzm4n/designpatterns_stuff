package AbstractFactory;

public class WirelessDeviceFactory implements AbstractDeviceFactory {
    public Keyboard createKeyboard(){
        return new WirelessKeyboard();
    }

    public Speaker createSpeaker(){
        return new WirelessSpeaker();
    }

    public Headphones createHeadphones(){
        return new WirelessHeadphones();
    }
}
