package tower;

import weather.WeatherProvider;
import weather.Coordinate;

public class WeatherTower extends Tower {
    private WeatherProvider weatherProvider = WeatherProvider.getInstance();

    public String getWeather(Coordinate p_coordinates) {
        return weatherProvider.getCurrentWeather(p_coordinates);
    }

    public void changeWeather() {
        this.weatherProvider.increaseSeed();
        this.conditionChanged();
    }
}
