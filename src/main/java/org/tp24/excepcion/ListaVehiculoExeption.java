package org.tp24.excepcion;

public class ListaVehiculoExeption extends VehiculosException{

    public ListaVehiculoExeption(){
        super("Error al leer la lista de vehiculos, está vacía");
    }

}
