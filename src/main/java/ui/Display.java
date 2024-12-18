package ui;

import model.Car;
import java.util.List;

public class Display {
    public void showCars(List<Car> cars) {
        if (cars.isEmpty()) {
            System.out.println("No cars found.");
        } else {
            for (Car car : cars) {
                System.out.println(car.toString());
            }
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
