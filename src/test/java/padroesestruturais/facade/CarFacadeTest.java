package padroesestruturais.facade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarFacadeTest {

    @Test
    void shouldStartCarWithDefaultConstructor() {
        assertTrue(new CarFacade().startCar());
    }

    @Test
    void shouldTurnOnAllSystemsWhenStartingCar() {
        Battery battery = new Battery(true);
        FuelPump fuelPump = new FuelPump(true);
        Engine engine = new Engine();
        ClimateControl climateControl = new ClimateControl();
        Dashboard dashboard = new Dashboard();
        CarFacade car = new CarFacade(battery, fuelPump, engine, climateControl, dashboard);

        assertTrue(car.startCar());
        assertTrue(battery.isConnected());
        assertTrue(fuelPump.isPumping());
        assertTrue(engine.isRunning());
        assertTrue(climateControl.isOn());
        assertTrue(dashboard.isOn());
        assertEquals("Car started", dashboard.getMessage());
    }

    @Test
    void shouldNotStartCarWhenBatteryIsDead() {
        FuelPump fuelPump = new FuelPump(true);
        Engine engine = new Engine();
        ClimateControl climateControl = new ClimateControl();
        Dashboard dashboard = new Dashboard();
        CarFacade car = new CarFacade(new Battery(false), fuelPump, engine, climateControl, dashboard);

        assertFalse(car.startCar());
        assertFalse(fuelPump.isPumping());
        assertFalse(engine.isRunning());
        assertFalse(climateControl.isOn());
        assertEquals("Battery dead", dashboard.getMessage());
    }

    @Test
    void shouldNotStartCarWhenThereIsNoFuel() {
        Engine engine = new Engine();
        ClimateControl climateControl = new ClimateControl();
        Dashboard dashboard = new Dashboard();
        CarFacade car = new CarFacade(new Battery(true), new FuelPump(false), engine, climateControl, dashboard);

        assertFalse(car.startCar());
        assertFalse(engine.isRunning());
        assertFalse(climateControl.isOn());
        assertEquals("No fuel", dashboard.getMessage());
    }
}
