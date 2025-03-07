package aircraft;

import weather.Coordinate;
import interfaces.Flyable;

public class AircraftFactory {
    static long id_counter = 0;

    public static Flyable newAircraft(String p_type, String p_name, Coordinate p_coordinates) {
        long id = ++id_counter;
        switch (p_type) {
            case "Helicopter":
                return new Helicopter(id, p_name, p_coordinates);
            case "JetPlane":
                return new JetPlane(id, p_name, p_coordinates);
            case "Baloon":
                return new Baloon(id, p_name, p_coordinates);
            default:
                throw new IllegalArgumentException("Unknown aircraft type: " + p_type);
        }
    }
}
