package aircraft;

import weather.Coordinate;

public class Baloon extends Aircraft {
    public Baloon(long p_id, String p_name, Coordinate p_coordinate) {
        super(p_id, p_name, p_coordinate);
        this.type = "Baloon";
    }

    @Override
    public void updateConditions() {
        String weather = this.weatherTower.getWeather(this.coordinate);
        switch (weather) {
            case "SUN":
                System.out.println(this.getHandle() + ": Let's enjoy the good weather and take some pics.");
                this.changeCoordinates(2, 0, 4);
                break;
            case "RAIN":
                System.out.println(this.getHandle() + ": Damn you rain! You messed up my baloon.");
                this.changeCoordinates(0, 0, -5);
                break;
            case "FOG":
                System.out.println(this.getHandle() + ": Cant see my own hand in front of my eyes.");
                this.changeCoordinates(0, 0, -3);
                break;
            case "SNOW":
                System.out.println(this.getHandle() + ": It's snowing. We're gonna crash.");
                this.changeCoordinates(0, 0, -15);
                break;
            default:
                throw new IllegalArgumentException("Error for " + this.getHandle() + " unknown weather: \"" + weather + "\"");
        }
    }
}

