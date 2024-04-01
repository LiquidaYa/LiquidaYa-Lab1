package org.tp24.service;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

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
    public Vehiculo buscarPorPlaca(String placa){
      var vehicle = interfacevehiculo.buscar(placa);
       if (vehicle == null) {
            throw new PlacaExeption(placa);
        }
        return vehicle;
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


