package LiquidaYa.repository.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import LiquidaYa.exception.ListVehicleException;
import LiquidaYa.model.Vehicle;
import LiquidaYa.repository.VehicleRepository;

public class VehicleRepositoryImpl implements VehicleRepository {

    @Override
    public List<Vehicle> getAll() throws ListVehicleException {
        Path path = Paths.get("./src/main/resources/VehiculosBD.txt");

        try (Stream<String> stream = Files.lines(path)) {
            return stream.map(this::build).toList();
        } catch (IOException e) {

            throw new ListVehicleException();

        }

    }

    private Vehicle build(String text) {
        String[] VehicleArray = text.split(",");
        
  
        return new Vehicle(VehicleArray[0], VehicleArray[1], VehicleArray[2], VehicleArray [3]);
    }

    @Override
    public List<Vehicle> find(String plate) {

        List<Vehicle> matchingVehicles = new ArrayList<>();

        Path path = Paths.get("./src/main/resources/VehiculosBD.txt");
        String line = null;

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                if (values[0].equals(plate)) {
                    matchingVehicles.add(new Vehicle(values[0], values[1], values[2], values[3]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return matchingVehicles;
    }

    @Override
    public Vehicle add(Vehicle vehicle) {
        Path path = Paths.get("./src/main/resources/VehiculosBD.txt");
        String line = MessageFormat.format("{0},{1},{2},{3}", vehicle.plate(), vehicle.responsible(),vehicle.company(), vehicle.mark());
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND)) {
            writer.newLine();
            writer.write(line);

        } catch (IOException e) {
            throw new ListVehicleException();
        }
        return vehicle;
    }

    



}
