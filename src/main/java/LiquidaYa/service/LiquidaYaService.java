package LiquidaYa.service;

import LiquidaYa.model.*;
import java.util.List;

import LiquidaYa.exception.ListVehicleException;
import LiquidaYa.exception.PlateException;

public interface LiquidaYaService {

    List<Vehicle> getAll() throws ListVehicleException;
    List<Vehicle> find(String plate) throws PlateException;
    Vehicle add(Vehicle vehicle);

}
