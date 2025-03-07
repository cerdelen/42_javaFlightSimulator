package simulation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import interfaces.Flyable;
import tower.WeatherTower;
import weather.Coordinate;
import aircraft.*;

public class Parser {
    private String filePath;
    private int simulationCycles;
    private List<String[]> aircraftData;

    public Parser(String filePath) {
        this.filePath = filePath;
        this.aircraftData = new ArrayList<>();
    }

    public void parse() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            if (line == null) {
                throw new IOException("Empty file");
            }
            simulationCycles = Integer.parseInt(line.trim());

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                String[] parts = line.split(" ");
                if (parts.length != 5) {
                    throw new IOException("Invalid aircraft format: " + line);
                }
                aircraftData.add(parts);
            }
        }
    }

    public int getSimulationCycles() {
        return simulationCycles;
    }

    public List<Flyable> createAircraft(WeatherTower weatherTower) {
        List<Flyable> aircraftList = new ArrayList<>();
        for (String[] data : aircraftData) {
            String type = data[0];
            String name = data[1];
            int longitude = Integer.parseInt(data[2]);
            int latitude = Integer.parseInt(data[3]);
            int height = Integer.parseInt(data[4]);

            Coordinate coordinate = new Coordinate(longitude, latitude, height);
            Flyable aircraft = AircraftFactory.newAircraft(type, name, coordinate);
            aircraft.registerToTower(weatherTower);
            aircraftList.add(aircraft);
        }
        return aircraftList;
    }
}
