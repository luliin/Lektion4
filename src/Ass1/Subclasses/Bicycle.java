package Ass1.Subclasses;

import Ass1.IPrintable;
import Ass1.Vehicle;

/**
 * Created by Julia Wigenstedt
 * Date: 2020-09-22
 * Time: 14:22
 * Project: Lektion4
 * Copyright: MIT
 */
public class Bicycle extends Vehicle {
    private final int numberOfGears;
    private int gear;

    public int getNumberOfGears() {
        return numberOfGears;
    }

    public int getGear() {
        return gear;
    }

    public Bicycle(int speed, int weight, int numberOfGears, int gear){
        super(speed, weight);
        numberOfWheels=2;
        if (gear>=0 && gear<=numberOfGears) {
            this.gear = gear;
        }
        else {
            throw new IllegalArgumentException("Cykeln kan inte stå på en växel som är lägre än 0 eller högre än antal växlar.");
        }

        if(numberOfGears>=0) {
            this.numberOfGears=numberOfGears;
        }

        else {
            throw new IllegalArgumentException("Cykeln måste ha 0 eller fler växlar.");
        }

    }
    public void changeGears(int newGear){
        if (gear==newGear){
            System.out.println(gear + " växel ligger redan i.");
        } else if (newGear>numberOfGears) {
            System.out.println("Det finns inte " + newGear + " växlar på denna cykel.");
        } else gear = newGear;
    }
    @Override
    public void printMe() {
        System.out.printf("Cykelns vikt: %d kg, Hastighet: %d km/h, Antal växlar: %d, Växel just nu: %d\n", getWeight(), getSpeed(), getNumberOfGears() ,getGear());
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
