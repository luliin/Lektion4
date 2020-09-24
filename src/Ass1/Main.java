package Ass1;

import Ass1.Subclasses.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julia Wigenstedt
 * Date: 2020-09-24
 * Time: 13:22
 * Project: Lektion4
 * Copyright: MIT
 */

public class Main {
    static List<Vehicle> vehicles = new ArrayList<>();

    public static void main(String[] args) {


        Car car = new Car(5, 1, 1500, 200);
        Bicycle bike = new Bicycle(45, 25, 7, 1);
        Train train = new Train(6, 250, 10);
        Boat boat = new Boat(200, 1000, 20);

        vehicles.add(car);
        vehicles.add(bike);
        vehicles.add(train);
        vehicles.add(boat);

        for(var vehicle: vehicles){
            vehicle.printVehicle(vehicle);
            if(vehicle.getNumberOfWheels()>0) {
                System.out.println(vehicle.getNumberOfWheels() + " hjul");
            } else {
                System.out.println("Det finns inga hjul på detta fordon.");
            }
        }
    }
}
