package Ass1.Subclasses;

import Ass1.Vehicle;

/**
 * Created by Julia Wigenstedt
 * Date: 2020-09-22
 * Time: 14:22
 * Project: Lektion4
 * Copyright: MIT
 */
public class Boat extends Vehicle {
    private int deadWeight;


    public Boat(int deadWeight, int weight, int speed){
        super(speed, weight);
        numberOfWheels=0;
        this.deadWeight=deadWeight;
    }
    public void turn(){}

    public int getDeadWeight() {
        return deadWeight;
    }

    @Override
    public void printMe() {
        System.out.printf("Båtens vikt: %d kg, Hastighet: %d knop, Dödvikt: %d kg\n", getWeight(), getSpeed(), getDeadWeight());
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
