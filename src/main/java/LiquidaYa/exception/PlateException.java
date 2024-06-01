package LiquidaYa.exception;

import java.text.MessageFormat;

public class PlateException extends VehiclesException{
        
        public PlateException(String placa) {
            super(MessageFormat.format("Vehicle with plate {0} not found", placa));   
        }   
}
