package padroesestruturais.facade;

public class FuelPump {

    private final boolean hasFuel;
    private boolean pumping;

    public FuelPump(boolean hasFuel) {
        this.hasFuel = hasFuel;
    }

    public boolean start() {
        this.pumping = this.hasFuel;
        return this.pumping;
    }

    public boolean isPumping() {
        return this.pumping;
    }
}
