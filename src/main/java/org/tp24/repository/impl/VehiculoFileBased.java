package org.tp24.repository.impl;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;
import java.util.stream.Stream;

import org.tp24.data.Vehiculo;
import org.tp24.excepcion.ListaVehiculoExeption;
import org.tp24.repository.VehiculosRepository;

public class VehiculoFileBased implements VehiculosRepository {

    @Override
    public List<Vehiculo> getAll() throws ListaVehiculoExeption {
        Path path = Paths.get("./src/main/resources/VehiculosBD.txt");

        try (Stream<String> stream = Files.lines(path)) {
            return stream.map(this::build).toList();
        } catch (IOException e) {

            throw new ListaVehiculoExeption();

        }

    }

    private Vehiculo build(String text) {
        String[] VehiculoArray = text.split(",");
        
  
        return new Vehiculo(VehiculoArray[0], VehiculoArray[1], VehiculoArray[2], VehiculoArray [3]);
    }

    @Override
    public Vehiculo buscar(String placa) {

        return null;
    }

    @Override
    public List<Vehiculo> buscar(String responsable, String empresa) {
        return null;
    }

}
