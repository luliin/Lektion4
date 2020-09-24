package Ass1.Subclasses;

import Ass1.Vehicle;

/**
 * Created by Julia Wigenstedt
 * Date: 2020-09-22
 * Time: 14:22
 * Project: Lektion4
 * Copyright: MIT
 */
public class Train extends Vehicle {
    private int numberOfWagons;


    public Train(int weight, int speed, int numberOfWagons){
        super(speed, weight);
        this.numberOfWagons=numberOfWagons;
        numberOfWheels = 8*numberOfWagons;
    }
    public void connectTrolley(){}

    public int getNumberOfWagons() {
        return numberOfWagons;
    }

    @Override
    public void printMe() {
        System.out.printf("Tågets vikt: %d ton, Hastighet: %d km/h, Antal vagnar: %d\n", getWeight(), getSpeed(), getNumberOfWagons());
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
