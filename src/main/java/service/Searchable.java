package service;

import model.Car;

import java.util.List;

public interface Searchable {
    List<Car> searchByMake(String make);
    List<Car> searchByYear(int year);
    List<Car> searchByHorsepower(int horsepower);
}
