package LiquidaYa.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import LiquidaYa.exception.ListVehicleException;
import LiquidaYa.exception.PlateException;
import LiquidaYa.model.Vehicle;
import LiquidaYa.repository.impl.VehicleRepositoryImpl;
import LiquidaYa.service.LiquidaYaService;
import LiquidaYa.service.impl.LiquidaYaServiceImpl;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500") // Permite el acceso desde tu frontend
public class LiquidaYaController {

    private final LiquidaYaService liquidaYaService;

    public LiquidaYaController(){
        this.liquidaYaService = new LiquidaYaServiceImpl(new VehicleRepositoryImpl());
    }

    @GetMapping("/vehiculos")
    public ResponseEntity<List<Vehicle>> getAll() throws ListVehicleException {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(liquidaYaService.getAll());
        } catch (ListVehicleException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("ERROR NAME", e.getMessage())
                    .body(Collections.emptyList());
        }
    }

    @GetMapping("/vehiculos/{plate}")
    public ResponseEntity<List<Vehicle>> find(@PathVariable String plate) throws PlateException {
        System.out.println("Solicitud recibida para la placa: " + plate);
        try {
            List<Vehicle> vehicles = liquidaYaService.find(plate);
            System.out.println("Vehículos encontrados: " + vehicles);
            return ResponseEntity.status(HttpStatus.OK).body(vehicles);
        } catch (PlateException e) {
            System.out.println("Excepción encontrada: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("NO VEHICLE FOUND", e.getMessage())
                    .body(Collections.emptyList());
        }
    }

    @PostMapping("/vehiculos")
    public ResponseEntity<Vehicle> add(@RequestBody Vehicle vehicle) {
        return ResponseEntity.status(HttpStatus.OK).body(liquidaYaService.add(vehicle));
    }
}