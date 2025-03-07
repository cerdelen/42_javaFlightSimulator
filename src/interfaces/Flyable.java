package interfaces;

import tower.WeatherTower;

public abstract class Flyable {
    protected WeatherTower weatherTower;

    public abstract void updateConditions();

    public void registerToTower(WeatherTower p_weatherTower) {
        this.weatherTower = p_weatherTower;
        weatherTower.register(this);
    }
}
