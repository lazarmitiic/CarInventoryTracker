package model;

public abstract class AbstractCar {
    private String make;
    private String model;
    private int year;
    private double price;
    private int horsepower;

    public AbstractCar(String make, String model, int year, double price, int horsepower) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.horsepower = horsepower;
    }

    // Getters and Setters
    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getHorsepower() { return horsepower; }
    public void setHorsepower(int horsepower) { this.horsepower = horsepower; }

    @Override
    public String toString() {
        return "Make: " + make + ", Model: " + model + ", Year: " + year +
                ", Price: $" + price + ", Horsepower: " + horsepower;
    }
}
