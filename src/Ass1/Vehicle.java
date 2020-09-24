package Ass1;

import Ass1.Subclasses.IWheeled;

/**
 * Created by Julia Wigenstedt
 * Date: 2020-09-22
 * Time: 14:21
 * Project: Lektion4
 * Copyright: MIT
 */
public abstract class Vehicle implements IPrintable, IWheeled {
    protected int speed;
    protected int weight;
    protected int numberOfWheels;

    public Vehicle(){}

    public Vehicle(int speed, int weight){
        this.speed = speed;
        this.weight = weight;
    }

    public void changeSpeed(int newSpeed){
        speed=newSpeed;
    }

    public int getSpeed() {
        return speed;
    }

    public int getWeight() {
        return weight;
    }
    public abstract void printMe();
}
