package org.tp24.excepcion;

public class ResponsableEmpresaExeption extends VehiculosExeptions {
    
    public ResponsableEmpresaExeption(String responsable, String empresa) {
        super("Vehículo cuyo responsable es: "+responsable+" y su empresa es: "+empresa+" no encontrado");

    }

}
