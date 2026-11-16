package padroesestruturais.facade;

public class ClimateControl {

    private boolean on;

    public void turnOn() {
        this.on = true;
    }

    public boolean isOn() {
        return this.on;
    }
}
