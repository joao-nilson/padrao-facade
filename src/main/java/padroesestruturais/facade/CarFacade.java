package padroesestruturais.facade;

public class CarFacade {

    private final Battery battery;
    private final FuelPump fuelPump;
    private final Engine engine;
    private final ClimateControl climateControl;
    private final Dashboard dashboard;

    public CarFacade() {
        this(new Battery(true), new FuelPump(true), new Engine(), new ClimateControl(), new Dashboard());
    }

    public CarFacade(Battery battery, FuelPump fuelPump, Engine engine,
                     ClimateControl climateControl, Dashboard dashboard) {
        this.battery = battery;
        this.fuelPump = fuelPump;
        this.engine = engine;
        this.climateControl = climateControl;
        this.dashboard = dashboard;
    }

    public boolean startCar() {
        if (!battery.connect()) {
            dashboard.show("Battery dead");
            return false;
        }
        if (!fuelPump.start()) {
            dashboard.show("No fuel");
            return false;
        }
        engine.start();
        climateControl.turnOn();
        dashboard.show("Car started");
        return true;
    }
}
