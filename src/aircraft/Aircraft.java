package aircraft;

import interfaces.Flyable;
import weather.Coordinate;

public abstract class Aircraft extends Flyable {
    protected Coordinate coordinate;
    protected String name;
    protected long id;
    protected String type;

    protected Aircraft(long p_id, String p_name, Coordinate p_coordinate) {
        this.name = p_name;
        this.coordinate = p_coordinate;
        this.id = p_id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public long getId() {
        return id;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public String getHandle() {
        return type + "#" + name + "(" + id + ")";
    }

    public void changeCoordinates(int p_long, int p_lat, int p_height) {
        if (this.coordinate.getHeight() + p_height <= 0) {
            System.out.println(this.getHandle() + " landed!");
            this.weatherTower.unregister(this);
        } else if (this.coordinate.getHeight() + p_height > 100) {
            this.coordinate.update(p_long, p_lat, 100);
        } else {
            this.coordinate.update(p_long, p_lat, p_height);
        }
    }
}
