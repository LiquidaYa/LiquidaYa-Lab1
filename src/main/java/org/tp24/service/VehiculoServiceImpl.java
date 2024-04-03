package org.tp24.service;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import org.tp24.data.Vehiculo;
import org.tp24.excepcion.ListaVehiculoExeption;
import org.tp24.excepcion.PlacaExeption;
import org.tp24.excepcion.ResponsableEmpresaExeption;
import org.tp24.repository.VehiculosRepository;

public class VehiculoServiceImpl {
    private VehiculosRepository interfacevehiculo;

    public VehiculoServiceImpl(VehiculosRepository interfacevehiculo) {
        this.interfacevehiculo = interfacevehiculo;
    }
    public List<Vehiculo> getAll() {
        return interfacevehiculo.getAll();
    }
    public Vehiculo buscarPorPlaca(String placa) {
        Path path = Paths.get("./src/main/resources/VehiculosBD.txt");
        String line = null;
        
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            while ((line = reader.readLine())!= null) {
                String[] values = line.split(",");
                if (values[0].equals(placa)) {
                    return new Vehiculo(values[0], values[1], values[2], values[3]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        throw new PlacaExeption(placa);
    }
    public List<Vehiculo> buscarPorResponsableEmpresa(String responsable, String empresa){
        var vehicles = interfacevehiculo.buscar(responsable, empresa);
        if (vehicles.isEmpty()) {
            throw new ResponsableEmpresaExeption(responsable, empresa);
        }
        return vehicles;
    }
    
    public void agregarVehiculoAlArchivo(Vehiculo vehiculo) throws ListaVehiculoExeption {
        Path path = Paths.get("./src/main/resources/VehiculosBD.txt");
        String linea = vehiculo.placa() + "," + vehiculo.responsable() + "," + vehiculo.empresa() + "," + vehiculo.marca();
    
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND)) {
            writer.newLine();
            writer.write(linea);

        } catch (IOException e) {
            throw new ListaVehiculoExeption();
        }
    }

}


