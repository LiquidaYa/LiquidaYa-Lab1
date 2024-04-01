package org.tp24.service;
import java.util.List;

import org.tp24.data.Vehiculo;
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

}


