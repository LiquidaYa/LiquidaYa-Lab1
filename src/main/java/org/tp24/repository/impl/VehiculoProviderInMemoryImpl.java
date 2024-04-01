package org.tp24.repository.impl;
import java.util.ArrayList;
import java.util.List;

import org.tp24.data.Vehiculo;

import org.tp24.repository.VehiculosRepository;

public class VehiculoProviderInMemoryImpl implements VehiculosRepository {

    private List<Vehiculo> listavehiculos;

    public VehiculoProviderInMemoryImpl() {

        listavehiculos = new ArrayList<Vehiculo>();
    }

    @Override
    public Vehiculo buscar(String placa) {

        return listavehiculos.stream().filter(p -> p.placa().equals(placa)).findFirst().orElse(null);
    }

    @Override
    public List<Vehiculo> buscar(String responsable, String empresa) {

        return listavehiculos.stream().filter(p -> equalName(p, responsable, empresa)).toList();

    }

    private boolean equalName(Vehiculo p, String responsable, String empresa) {

        if (p.responsable().equals(responsable) && p.empresa().equals(empresa)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Vehiculo> getAll() {

        return listavehiculos;
    }

}
