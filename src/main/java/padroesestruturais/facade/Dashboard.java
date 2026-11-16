package padroesestruturais.facade;

public class Dashboard {

    private boolean on;
    private String message = "";

    public void show(String message) {
        this.on = true;
        this.message = message;
    }

    public boolean isOn() {
        return this.on;
    }

    public String getMessage() {
        return this.message;
    }
}
