package core_java_and_oop;

interface Drivable {
    void accelerate(int speedIncrement);
    void brake(int speedDecrement);
}

abstract class Vehicle implements Drivable {

    private String brand;
    private String model;
    private int currentSpeed;

    public Vehicle(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.currentSpeed = 0;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    protected void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = Math.max(0, currentSpeed);
    }

    public abstract void startEngine();

    public void displayInfo() {
        System.out.println("Vehicle: " + brand + " " + model + " | Current Speed: " + currentSpeed + " km/h");
    }
}

class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String brand, String model, int numberOfDoors) {
        super(brand, model);
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    @Override
    public void startEngine() {
        System.out.println(getBrand() + " " + getModel() + ": Car engine started with push button.");
    }

    @Override
    public void accelerate(int speedIncrement) {
        setCurrentSpeed(getCurrentSpeed() + speedIncrement);
        System.out.println(getBrand() + " " + getModel() + " accelerated by " + speedIncrement + " km/h. Speed: " + getCurrentSpeed() + " km/h");
    }

    @Override
    public void brake(int speedDecrement) {
        setCurrentSpeed(getCurrentSpeed() - speedDecrement);
        System.out.println(getBrand() + " " + getModel() + " braked by " + speedDecrement + " km/h. Speed: " + getCurrentSpeed() + " km/h");
    }

    public void playMusic() {
        System.out.println("Playing default radio playlist.");
    }

    public void playMusic(String songName) {
        System.out.println("Playing specific track: " + songName);
    }

    public void playMusic(String playlist, boolean shuffle) {
        System.out.println("Playing playlist '" + playlist + "' (Shuffle: " + shuffle + ")");
    }
}

class ElectricCar extends Car {
    private int batteryPercentage;

    public ElectricCar(String brand, String model, int numberOfDoors, int batteryPercentage) {
        super(brand, model, numberOfDoors);
        this.batteryPercentage = batteryPercentage;
    }

    public int getBatteryPercentage() {
        return batteryPercentage;
    }

    @Override
    public void startEngine() {
        System.out.println(getBrand() + " " + getModel() + ": Electric motor activated silently. Battery: " + batteryPercentage + "%");
    }
}

public class OOPDemonstration {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("   DEMONSTRATING 4 CORE OOP PRINCIPLES IN JAVA   ");
        System.out.println("=================================================");

        Vehicle sedan = new Car("Honda", "Civic", 4);
        Vehicle ev = new ElectricCar("Tesla", "Model 3", 4, 88);

        sedan.startEngine();
        sedan.accelerate(50);
        sedan.brake(20);
        sedan.displayInfo();
        System.out.println();

        ev.startEngine();
        ev.accelerate(70);
        ev.brake(30);
        ev.displayInfo();
        System.out.println();

        Car sportsCar = new Car("Ford", "Mustang", 2);
        sportsCar.playMusic();
        sportsCar.playMusic("Bohemian Rhapsody");
        sportsCar.playMusic("Classic Rock", true);
    }
}
