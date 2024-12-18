package model;

public class NewCar extends Car {
    private int warrantyYears;

    public NewCar(String make, String model, int year, double price, int horsepower, int warrantyYears) {
        super(make, model, year, price, horsepower);
        this.warrantyYears = warrantyYears;
    }

    public int getWarrantyYears() { return warrantyYears; }
    public void setWarrantyYears(int warrantyYears) { this.warrantyYears = warrantyYears; }

    @Override
    public String toString() {
        return super.toString() + ", Warranty: " + warrantyYears + " years";
    }
}
