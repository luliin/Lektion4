package Ass2.Subclasses;

import Ass2.*;

import java.util.Scanner;

/**
 * Created by Julia Wigenstedt
 * Date: 2020-09-22
 * Time: 15:05
 * Project: Lektion3
 * Copyright: MIT
 */
public class CaravanAd extends VehicleAd {

    static Scanner in = new Scanner(System.in);

    private boolean hasShower;
    private int numberOfBeds;

    public CaravanAd(String heading, String brandModel, int modelYear, String color, int distanceTravelled, int price, String description, boolean hasShower, int numberOfBeds) {
        super(heading, brandModel, modelYear, color, distanceTravelled, price, description);
        this.hasShower = hasShower;
        this.numberOfBeds = numberOfBeds;
    }

    public boolean hasShower() {
        return hasShower;
    }


    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    @Override
    public String getAdText() {
        if (hasShower) {
            return String.format("%s %s, %d bäddar, årsmodell %d.\nHusvagnen har dusch och toalett!\n%s, %d mil, endast %d kr!\n%s\n",
                    getHeading(), getBrandModel(), getNumberOfBeds(), getModelYear(),
                    getColor(), getDistanceTravelled(), getPrice(), getDescription());
        } else {
            return String.format("%s %s, %d bäddar, årsmodell %d.\nHusvagnen har toalett, men saknar dusch!\n%s, %d mil, endast %d kr! \n%s\n",
                    getHeading(), getBrandModel(), getNumberOfBeds(), getModelYear(),
                    getColor(), getDistanceTravelled(), getPrice(), getDescription());
        }
    }

    @Override
    public String getHeader() {
        return String.format("%s %s, %d kr!\n", getHeading(), getBrandModel(), getPrice());

    }

    public static CaravanAd createCaravanAd() {
        boolean success = false;
        System.out.print("Ange rubrik: ");
        String header = WelcomeMenu.capitalize(in.nextLine());
        System.out.print("Ange märke och modellnamn: ");
        String brandModel = WelcomeMenu.capitalize(in.nextLine());
        String input = "";
        while (!success) {
            System.out.print("Ange årsmodell: ");
            input = in.nextLine();
            if (WelcomeMenu.tryParse(input)) {
                success = true;
            } else success = false;
        }
        int modelYear = Integer.parseInt(input);
        success = false;
        System.out.print("Ange färg: ");
        String color = WelcomeMenu.capitalize(in.nextLine());
        while (!success) {
            System.out.print("Ange antal mil: ");
            input = in.nextLine();
            if (WelcomeMenu.tryParse(input)) {
                success = true;
            } else success = false;
        }
        int distance = Integer.parseInt(input);
        success = false;
        while (!success) {
            System.out.print("Ange pris: ");
            input = in.nextLine();
            if (WelcomeMenu.tryParse(input)) {
                success = true;
            } else success = false;
        }
        int price = Integer.parseInt(input);
        System.out.print("Ange beskrivning: ");
        String description = WelcomeMenu.capitalize(in.nextLine());
        System.out.print("Har husvagnen dusch: (j/n)  ");
        String hasShowerString = in.nextLine();
        boolean hasShower = false;
        if (hasShowerString.equalsIgnoreCase("j")) {
            hasShower = true;
        }
        success = false;
        while (!success) {
            System.out.print("Ange antal bäddar: ");
            input = in.nextLine();
            if (WelcomeMenu.tryParse(input)) {
                success = true;
            } else success = false;
        }
        int beds = Integer.parseInt(input);
        return new CaravanAd(header, brandModel, modelYear, color, distance, price, description, hasShower, beds);
    }

    @Override
    public void printHeader() {
        System.out.println(getHeader());
    }

    @Override
    public void printCompleteAd() {
        System.out.println(getAdText());
    }

    @Override
    public double calculateRevenue() {
        return getPrice()/1.25;
    }
}
