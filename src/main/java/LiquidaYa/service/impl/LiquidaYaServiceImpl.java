package LiquidaYa.service.impl;

import java.util.List;

import LiquidaYa.exception.ListVehicleException;
import LiquidaYa.exception.PlateException;
import LiquidaYa.model.Vehicle;
import LiquidaYa.repository.VehicleRepository;
import LiquidaYa.service.LiquidaYaService;

public class LiquidaYaServiceImpl implements LiquidaYaService{
    private VehicleRepository vehicleRepository;

    public LiquidaYaServiceImpl(VehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }
    @Override
    public List<Vehicle> getAll() throws ListVehicleException {
        List<Vehicle> vehicles = vehicleRepository.getAll();
        if(vehicles.isEmpty()){
            throw new ListVehicleException();
        }
        return vehicles;
    }
    @Override
    public List<Vehicle> find(String plate) {
        List<Vehicle> vehicles = vehicleRepository.find(plate);
        if(vehicles.isEmpty()){
            throw new PlateException(plate);
        }else{
            return vehicles;
        }
    }
    @Override
    public Vehicle add(Vehicle vehicle) {
        Vehicle vehicleAdd = vehicleRepository.add(vehicle);
        return vehicleAdd;
    }
    

}
