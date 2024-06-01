import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import LiquidaYa.exception.ListVehicleException;
import LiquidaYa.exception.PlateException;
import LiquidaYa.model.Vehicle;
import LiquidaYa.repository.VehicleRepository;
import LiquidaYa.service.LiquidaYaService;
import LiquidaYa.service.impl.LiquidaYaServiceImpl;

public class LiquidaYaServiceTest {
    private LiquidaYaService liquidaYaService;
    private VehicleRepository vehicleRepository = Mockito.mock();

    private Vehicle exampleVehicle1 = new Vehicle("szq649", "angel yepes j", "ngm", "kenworth");
    private Vehicle exampleVehicle2 = new Vehicle("sns266", "angel yepes j", "ngm", "kenworth");
    private Vehicle exampleVehicle3 = new Vehicle("trc913", "angel yepes j", "ngm", "kenworth");

    @BeforeEach
    void init() {
        liquidaYaService = new LiquidaYaServiceImpl(vehicleRepository);
    }

    @Test
    void whenFindForPlateShouldBeReturnedSuccesfully() throws PlateException {

        mockVehicleRepositoryFind("szq649", List.of(exampleVehicle1));
        List<Vehicle> vehicles = liquidaYaService.find("szq649");
        assertEquals(1, vehicles.size());
        assertEquals(exampleVehicle1, vehicles.get(0));
    }

    @Test
    void whenFindForPlateAnPlateExceptionShouldBeThrownSuccesfully() throws PlateException {

        mockVehicleRepositoryFind(null, Collections.emptyList());
        assertThrows(PlateException.class, () -> {
            liquidaYaService.find("tmu950");
        });
    }

    @Test
    void whenGetAllDoesNotFindAnyVehicleanVideoNotFoundExceptionShouldBeThrownSuccesfully() {
        mockVehicleRepositoryGetAll(Collections.emptyList());
        assertThrows(ListVehicleException.class, () -> {
            liquidaYaService.getAll();
        });
    }

    @Test
    void whenGetAllAllVideosShouldBeReturnedSuccesfully() throws ListVehicleException{

        mockVehicleRepositoryGetAll( 
            List.of(
                exampleVehicle1, 
                exampleVehicle2, 
                exampleVehicle3)
        );
        List <Vehicle> vehicles = liquidaYaService.getAll();
        assertEquals(3, vehicles.size()); 


    }

    private void mockVehicleRepositoryFind(String plate, List<Vehicle> vehicles) {
        doReturn(vehicles).when(vehicleRepository).find(eq(plate));
    }

    private void mockVehicleRepositoryGetAll(List<Vehicle> vehicles) {
        doReturn(vehicles).when(vehicleRepository).getAll();

    }

}
