package ui;

import exception.InvalidCarDataException;
import model.Car;
import model.NewCar;
import model.UsedCar;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {
    private final Scanner scanner;

    public UserInput() {
        scanner = new Scanner(System.in);
    }

    public Car getUserCarInput() throws InvalidCarDataException {
        System.out.println("Enter car type (new/used): ");
        String type = getUserStringInput().trim().toLowerCase();

        System.out.println("Enter make: ");
        String make = getUserStringInput();

        System.out.println("Enter model: ");
        String model = getUserStringInput();

        System.out.println("Enter year: ");
        int year = getUserIntegerInput();

        System.out.println("Enter price: ");
        double price = getUserDoubleInput();

        System.out.println("Enter horsepower: ");
        int horsepower = getUserIntegerInput();

        if (type.equals("new")) {
            System.out.println("Enter warranty years: ");
            int warrantyYears = getUserIntegerInput();
            return new NewCar(make, model, year, price, horsepower, warrantyYears);
        } else if (type.equals("used")) {
            System.out.println("Enter mileage: ");
            int mileage = getUserIntegerInput();

            System.out.println("Enter number of previous owners: ");
            int previousOwners = getUserIntegerInput();
            return new UsedCar(make, model, year, price, horsepower, mileage, previousOwners);
        } else {
            throw new InvalidCarDataException("Invalid car type.");
        }
    }

    public int getUserIntegerInput() {
        while (true) {
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }

    public double getUserDoubleInput() {
        while (true) {
            try {
                double value = Double.parseDouble(scanner.nextLine().trim());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    public String getUserStringInput() {
        return scanner.nextLine().trim();
    }

    public void close() {
        scanner.close();
    }
}
