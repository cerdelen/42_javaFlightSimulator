package aircraft;

import weather.Coordinate;

public class JetPlane extends Aircraft {
    public JetPlane(long p_id, String p_name, Coordinate p_coordinate) {
        super(p_id, p_name, p_coordinate);
        this.type = "JetPlane";
    }

    @Override
    public void updateConditions() {
        String weather = this.weatherTower.getWeather(this.coordinate);
        switch (weather) {
            case "SUN":
                System.out.println(this.getHandle() + ": Nice to have some Sun for a change!");
                this.changeCoordinates(0, 10, 2);
                break;
            case "RAIN":
                System.out.println(this.getHandle() + ": It's raining. Better watch out for lightings.");
                this.changeCoordinates(0, 5, 0);
                break;
            case "FOG":
                System.out.println(this.getHandle() + ": Quite foggy up here!");
                this.changeCoordinates(0, 1, 0);
                break;
            case "SNOW":
                System.out.println(this.getHandle() + ": OMG! Winter is coming!");
                this.changeCoordinates(0, 0, -7);
                break;
            default:
                throw new IllegalArgumentException("Error for " + this.getHandle() + " unknown weather: " + weather);
        }
    }
}
