package org.tp24.repository.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Stream;

import org.tp24.data.Vehiculo;
import org.tp24.excepcion.ListaVehiculoExeption;
import org.tp24.excepcion.PlacaExeption;
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

    @Override
    public List<Vehiculo> buscar(String responsable, String empresa) {
        return null;
    }

    @Override
    public Vehiculo agregar(Vehiculo vehiculo) {
        Path path = Paths.get("./src/main/resources/VehiculosBD.txt");
        String linea = MessageFormat.format("{0},{1},{2},{3}", vehiculo.placa(), vehiculo.responsable(),vehiculo.empresa(), vehiculo.marca());
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND)) {
            writer.newLine();
            writer.write(linea);

        } catch (IOException e) {
            throw new ListaVehiculoExeption();
        }
        return vehiculo;
    }

    



}
