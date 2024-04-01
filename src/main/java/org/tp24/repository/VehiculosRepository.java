package org.tp24.repository;
import java.util.List;
import org.tp24.data.Vehiculo;

public interface VehiculosRepository {

    Vehiculo buscar(String placa);
    List<Vehiculo> buscar(String responsable, String empresa);
    List<Vehiculo> getAll();

}
