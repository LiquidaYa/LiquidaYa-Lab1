package org.tp24;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tp24.data.Vehiculo;
import org.tp24.excepcion.PlacaExeption;
import org.tp24.repository.impl.VehiculoFileBased;
import org.tp24.service.VehiculoServiceImpl;




public class ApplicationRunner {
    
    private static final Logger logger = LoggerFactory.getLogger(ApplicationRunner.class);

    public void main() {
        VehiculoServiceImpl vehiculoService = new VehiculoServiceImpl(new VehiculoFileBased());
        List<Vehiculo> vehicles = vehiculoService.getAll();
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

    public Vehiculo buscarPorPlaca(String placa) {
        Path path = Paths.get("./src/main/resources/VehiculosBD.txt");
        String line = null;

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            while ((line = reader.readLine())!= null) {
                String[] values = line.split(",");
                if (values[0].equals(placa)) {
                    logger.info("Vehiculo Encontrado: {}", line);
                    return new Vehiculo(values[0], values[1], values[2], values[3]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        throw new PlacaExeption(placa);
    }


    
}