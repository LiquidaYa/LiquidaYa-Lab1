package org.tp24;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tp24.data.Vehiculo;

import org.tp24.repository.impl.VehiculoFileBased;
import org.tp24.service.VehiculoServiceImpl;




public class ApplicationRunner {
    
    private static final Logger logger = LoggerFactory.getLogger(ApplicationRunner.class);

    public void main() {
        VehiculoServiceImpl vehiculoService = new VehiculoServiceImpl(new VehiculoFileBased());
        List<Vehiculo> vehicles = vehiculoService.getAll();
        //System.out.println(vehicles);
        logger.info("vehiculos: {}",vehicles);
      

    }
    public void agregarVehiculoAlArchivo(Vehiculo vehiculo) {
      
        VehiculoServiceImpl vehiculoService = new VehiculoServiceImpl(new VehiculoFileBased());
        try {
            vehiculoService.agregarVehiculoAlArchivo(vehiculo);
        } catch (Exception e) {
            logger.error("Error al agregar vehiculo", e);
        }
    }
    
}