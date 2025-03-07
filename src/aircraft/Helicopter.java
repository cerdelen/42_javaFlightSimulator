package aircraft;

import weather.Coordinate;

public class Helicopter extends Aircraft {
    public Helicopter(long p_id, String p_name, Coordinate p_coordinate) {
        super(p_id, p_name, p_coordinate);
        this.type = "Helicopter";
    }

    @Override
    public void updateConditions() {
        String weather = this.weatherTower.getWeather(this.coordinate);
        switch (weather) {
            case "SUN":
                System.out.println(this.getHandle() + ": This is hot!");
                this.changeCoordinates(10, 0, 2);
                break;
            case "RAIN":
                System.out.println(this.getHandle() + ": Lets hope the Rotors wont rust!");
                this.changeCoordinates(5, 0, 0);
                break;
            case "FOG":
                System.out.println(this.getHandle() + ": Lets get out of the Fog!");
                this.changeCoordinates(1, 0, 0);
                break;
            case "SNOW":
                System.out.println(this.getHandle() + ": My rotor is going to freeze!");
                this.changeCoordinates(0, 0, -12);
                break;
            default:
                throw new IllegalArgumentException("Error for " + this.getHandle() + " unknown weather: " + weather);
        }
    }
}
