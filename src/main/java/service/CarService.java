package service;

import model.Car;
import model.NewCar;
import model.UsedCar;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarService implements Searchable {
    private List<Car> cars;

    public CarService() {
        this.cars = new ArrayList<>();
    }

    @Override
    public List<Car> searchByMake(String make) {
        return cars.stream()
                .filter(car -> car.getMake().equalsIgnoreCase(make))
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> searchByYear(int year) {
        return cars.stream()
                .filter(car -> car.getYear() == year)
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> searchByHorsepower(int horsepower) {
        return cars.stream()
                .filter(car -> car.getHorsepower() == horsepower)
                .collect(Collectors.toList());
    }

    public void sortByPrice(List<Car> cars) {
        cars.sort((c1, c2) -> Double.compare(c1.getPrice(), c2.getPrice()));
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void saveCarsToFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Car car : cars) {
                writer.write(car.toString());
                writer.newLine();
            }
        }
    }

    public void loadCarsFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Basic parsing, assuming format is correct and consistent
                String[] parts = line.split(", ");
                String make = parts[0].split(": ")[1];
                String model = parts[1].split(": ")[1];
                int year = Integer.parseInt(parts[2].split(": ")[1]);
                double price = Double.parseDouble(parts[3].split(": ")[1].substring(1));
                int horsepower = Integer.parseInt(parts[4].split(": ")[1]);

                if (line.contains("Warranty")) {
                    int warrantyYears = Integer.parseInt(parts[5].split(": ")[1].split(" ")[0]);
                    cars.add(new NewCar(make, model, year, price, horsepower, warrantyYears));
                } else if (line.contains("Mileage")) {
                    int mileage = Integer.parseInt(parts[5].split(": ")[1].split(" ")[0]);
                    int previousOwners = Integer.parseInt(parts[6].split(": ")[1].split(" ")[0]);
                    cars.add(new UsedCar(make, model, year, price, horsepower, mileage, previousOwners));
                } else {
                    cars.add(new Car(make, model, year, price, horsepower));
                }
            }
        }
    }
}
