package org.tp24.excepcion;

public class PlacaExeption extends VehiculosExeptions{
        
        public PlacaExeption(String placa) {
            super("Vehículo con placa: "+placa+" no encontrado");
    
        }
    
}
