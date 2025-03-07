package simulation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import aircraft.*;
import tower.WeatherTower;
import interfaces.Flyable;

public class FlightSimulator {
    public static void main(String[] args) {

        try {
            PrintStream fileOut = new PrintStream("simulation.txt");
            System.setOut(fileOut);
        } catch (FileNotFoundException e) {
            System.err.println("Error creating output file: " + e.getMessage());
            return;
        }

        if (args.length != 1) {
            System.out.println("Usage: java FlightSimulator <scenario-file>");
            return;
        }

        String scenarioFile = args[0];
        WeatherTower weatherTower = new WeatherTower();

        try {
            Parser parser = new Parser(scenarioFile);
            parser.parse();

            List<Flyable> aircraftList = parser.createAircraft(weatherTower);

            int simulationCycles = parser.getSimulationCycles();
            System.out.println("Starting simulation for " + simulationCycles + " cycles...");
            for (int i = 0; i < simulationCycles; i++) {
                // System.out.println("\nCycle " + (i + 1) + ":");
                weatherTower.changeWeather();
            }

            // System.out.println("\nSimulation complete. Thank you for flying with us!");
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format in file: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Error creating aircraft: " + e.getMessage());
        }
    }
}
