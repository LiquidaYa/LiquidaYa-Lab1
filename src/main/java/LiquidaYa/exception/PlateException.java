package LiquidaYa.exception;

import java.text.MessageFormat;

public class PlateException extends VehiclesException{
        
        public PlateException(String plate) {
            super(MessageFormat.format("Vehicle with plate {0} not found", plate));   
        }   
}
