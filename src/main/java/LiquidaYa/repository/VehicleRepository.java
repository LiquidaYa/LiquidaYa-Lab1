package LiquidaYa.repository;
import java.util.List;

import LiquidaYa.model.Vehicle;

public interface VehicleRepository {
    List<Vehicle> find(String plate);
    List<Vehicle> getAll();
    Vehicle add(Vehicle vehicle);
}
