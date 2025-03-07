package weather;

import java.util.Random;

public class WeatherProvider {
    static long seed = System.currentTimeMillis();
    private static WeatherProvider instance = null;
    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() {}

    public static WeatherProvider getInstance() {
        if (instance == null) {
            instance = new WeatherProvider();
        }
        return instance;
    }

    public void increaseSeed() {
        seed++;
    }

     public String getCurrentWeather(Coordinate p_coordinates) {
        Random random = new Random(p_coordinates.getLongitude() + p_coordinates.getLatitude() + p_coordinates.getHeight() + seed);
        int index = random.nextInt(weather.length);
        return weather[index];
    }
}
