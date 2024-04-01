package entrega1;

import org.junit.jupiter.api.Test;
import org.tp24.ApplicationRunner;
import org.tp24.data.Vehiculo;


public class test {
    @Test

    public void test1() {
        ApplicationRunner applicationRunner = new ApplicationRunner();
        Vehiculo carro = new Vehiculo("TRC913", "3334445566", "SALOGA","KENWORTH");
        applicationRunner.agregarVehiculoAlArchivo(carro);
        applicationRunner.main();
    }

}
