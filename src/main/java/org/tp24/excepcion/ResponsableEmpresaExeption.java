package org.tp24.excepcion;

import java.text.MessageFormat;

public class ResponsableEmpresaExeption extends VehiculosException {
    
    public ResponsableEmpresaExeption(String responsable, String empresa) {
        super(MessageFormat.format("Vehículo cuyo responsable es: {0} y su empresa es: {1} no encontrado",responsable,empresa));
    }

}
