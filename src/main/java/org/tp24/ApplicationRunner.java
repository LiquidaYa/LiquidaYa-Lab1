package org.tp24;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tp24.data.Vehiculo;

import org.tp24.repository.impl.VehiculoFileBased;
import org.tp24.service.VehiculoServiceImpl;




public class ApplicationRunner {
    
    private static final Logger logger = LoggerFactory.getLogger(ApplicationRunner.class);

    public static void main(String[] args) {
        VehiculoServiceImpl vehiculoService = new VehiculoServiceImpl(new VehiculoFileBased());
        List<Vehiculo> vehicles = vehiculoService.getAll();
        System.out.println(vehicles);




    }


}