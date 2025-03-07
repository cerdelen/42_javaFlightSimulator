package weather;

public class Coordinate {
    private int longitude;
    private int latitude;
    private int height;

    public Coordinate(int p_longitude, int p_latitude, int p_height) {
        this.update(p_longitude, p_latitude, p_height);
    }

    public void update(int p_longitude, int p_latitude, int p_height) {
        this.longitude = p_longitude;
        this.latitude = p_latitude;
        this.height = p_height;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }
}
