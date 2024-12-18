package service;

import model.Car;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    public List<Car> readCarsFromFile(String filename) throws IOException {
        List<Car> cars = new ArrayList<>();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(filename));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] carData = line.split(",");
                String make = carData[0].trim();
                String model = carData[1].trim();
                int year = Integer.parseInt(carData[2].trim());
                double price = Double.parseDouble(carData[3].trim());
                int horsepower = Integer.parseInt(carData[4].trim());
                Car car = new Car(make, model, year, price, horsepower);
                cars.add(car);
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
        }

        return cars;
    }

    public void writeCarsToFile(String filename, List<Car> cars) throws IOException {
        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter(filename));

            for (Car car : cars) {
                String carData = car.getMake() + "," + car.getModel() + "," + car.getYear() + "," + car.getPrice() + "," + car.getHorsepower();
                writer.write(carData);
                writer.newLine();
            }
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
