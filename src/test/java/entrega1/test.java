package entrega1;

import org.junit.jupiter.api.Test;
import org.tp24.ApplicationRunner;
import org.tp24.data.Vehiculo;

public class test {
    @Test

        public void test1(){
            ApplicationRunner applicationRunner = new ApplicationRunner();

            Vehiculo carro = new Vehiculo("SZQ649", "3005310000", "URIMAR","KENWORTH");
            System.out.println(carro);
        }   

}
