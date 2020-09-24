package Ass1.Subclasses;

import Ass1.Vehicle;

/**
 * Created by Julia Wigenstedt
 * Date: 2020-09-22
 * Time: 14:22
 * Project: Lektion4
 * Copyright: MIT
 */
public class Car extends Vehicle {
    private final int numberOfGears;
    private int gear;

    public Car(int numberOfGears, int gear, int weight, int speed){
        super(speed, weight);
        numberOfWheels=4;

        if (gear>=0 && gear<=numberOfGears) this.gear = gear;
        else {
            throw new IllegalArgumentException("Bilen kan inte stå på en växel som är lägre än 0 eller högre än antal växlar.");
        }

        if(numberOfGears>0) this.numberOfGears = numberOfGears;

        else {
            throw new IllegalArgumentException("Bilen måste ha fler än 0 växlar.");
        }
    }

    public void changeGears(int newGear){
        if (gear==newGear){
            System.out.println(gear + " växel ligger redan i.");
        } else if (newGear>numberOfGears) {
            System.out.println("Det finns inte " + newGear + " växlar i denna bil.");
        } else {
            gear = newGear;
        }
    }

    public int getNumberOfGears() {
        return numberOfGears;
    }

    public int getGear() {
        return gear;
    }

    @Override
    public void printMe() {
        System.out.printf("Bilens vikt: %d kg, Hastighet: %d km/h, Antal växlar: %d, Växel just nu: %d\n", getWeight(), getSpeed(), getNumberOfGears() ,getGear());
    }

    @Override
    public void printVehicle(Vehicle vehicle) {
        printMe();
    }

    @Override
    public int getNumberOfWheels() {
        return numberOfWheels;
    }
}
