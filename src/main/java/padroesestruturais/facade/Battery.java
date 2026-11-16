package padroesestruturais.facade;

public class Battery {

    private final boolean charged;
    private boolean connected;

    public Battery(boolean charged) {
        this.charged = charged;
    }

    public boolean connect() {
        this.connected = this.charged;
        return this.connected;
    }

    public boolean isConnected() {
        return this.connected;
    }
}
