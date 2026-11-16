package padroesestruturais.facade;

public class Engine {

    private boolean running;

    public void start() {
        this.running = true;
    }

    public boolean isRunning() {
        return this.running;
    }
}
