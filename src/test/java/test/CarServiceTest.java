package test;

import model.Car;
import model.NewCar;
import model.UsedCar;
import service.CarService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;

public class CarServiceTest {

    @Test
    public void testAddCar() {
        CarService carService = new CarService();
        Car car = new NewCar("Toyota", "Corolla", 2023, 20000, 150, 5);
        carService.addCar(car);
        assertTrue(carService.getCars().contains(car));
    }

    @Test
    public void testSearchByMake() {
        CarService carService = new CarService();
        Car car = new UsedCar("Ford", "Focus", 2019, 15000, 120, 30000, 1);
        carService.addCar(car);
        List<Car> result = carService.searchByMake("Ford");
        assertEquals(1, result.size());
        assertEquals("Ford", result.get(0).getMake());
    }

    @Test
    public void testLoadSaveCars() throws IOException {
        CarService carService = new CarService();
        Car car = new UsedCar("Chevrolet", "Malibu", 2018, 18000, 140, 50000, 2);
        carService.addCar(car);
        carService.saveCarsToFile("testCars.txt");

        CarService newCarService = new CarService();
        newCarService.loadCarsFromFile("testCars.txt");
        List<Car> cars = newCarService.getCars();
        assertEquals(1, cars.size());
        assertEquals("Chevrolet", cars.get(0).getMake());
    }
}
