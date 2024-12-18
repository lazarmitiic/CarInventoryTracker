package model;

public class UsedCar extends Car {
    private int mileage;
    private int previousOwners;

    public UsedCar(String make, String model, int year, double price, int horsepower, int mileage, int previousOwners) {
        super(make, model, year, price, horsepower);
        this.mileage = mileage;
        this.previousOwners = previousOwners;
    }

    public int getMileage() { return mileage; }
    public void setMileage(int mileage) { this.mileage = mileage; }

    public int getPreviousOwners() { return previousOwners; }
    public void setPreviousOwners(int previousOwners) { this.previousOwners = previousOwners; }

    @Override
    public String toString() {
        return super.toString() + ", Mileage: " + mileage + " km, Previous Owners: " + previousOwners;
    }
}
