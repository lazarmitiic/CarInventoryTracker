package ui;

import model.Car;
import service.CarService;
import exception.InvalidCarDataException;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String FILENAME = "cars.txt";

    public static void main(String[] args) {
        CarService carService = new CarService();
        UserInput userInput = new UserInput();
        Display display = new Display();

        try {
            // Load existing cars from file
            carService.loadCarsFromFile(FILENAME);

            boolean running = true;
            while (running) {
                System.out.println("Choose an option: \n1. Add Car \n2. Search by Make \n3. Exit");
                int choice = userInput.getUserIntegerInput();

                switch (choice) {
                    case 1:
                        try {
                            Car car = userInput.getUserCarInput();
                            carService.addCar(car);
                            display.showMessage("Car added successfully!");
                        } catch (InvalidCarDataException e) {
                            display.showMessage("Error: " + e.getMessage());
                        }
                        break;

                    case 2:
                        System.out.println("Enter make to search: ");
                        String make = userInput.getUserStringInput();
                        List<Car> cars = carService.searchByMake(make);
                        display.showCars(cars);
                        break;

                    case 3:
                        try {
                            // Save cars to file before exiting
                            carService.saveCarsToFile(FILENAME);
                            display.showMessage("Cars saved successfully!");
                        } catch (IOException e) {
                            display.showMessage("File error: " + e.getMessage());
                        }
                        running = false;
                        break;

                    default:
                        display.showMessage("Invalid option. Please choose again.");
                        break;
                }
            }

        } catch (IOException e) {
            display.showMessage("File error: " + e.getMessage());
        }
    }
}