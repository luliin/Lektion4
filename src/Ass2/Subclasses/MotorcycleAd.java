package Ass2.Subclasses;

import Ass2.*;

import java.util.Scanner;

/**
 * Created by Julia Wigenstedt
 * Date: 2020-09-22
 * Time: 15:06
 * Project: Lektion3
 * Copyright: MIT
 */
public class MotorcycleAd extends VehicleAd {
    static Scanner in = new Scanner(System.in);

    private String typeOfDrive;
    private int motorVolume;
    private boolean hasWinterTyres;

    public MotorcycleAd(String heading, String brandModel, int modelYear, String color, int distanceTravelled, int price, String description, int motorVolume, String typeOfDrive, boolean hasWinterTyres) {
        super(heading, brandModel, modelYear, color, distanceTravelled, price, description);
        this.hasWinterTyres = hasWinterTyres;
        this.typeOfDrive = typeOfDrive;
        this.motorVolume = motorVolume;
    }

    public boolean isHasWinterTyres() {
        return hasWinterTyres;
    }

    public void setHasWinterTyres(boolean hasWinterTyres) {
        this.hasWinterTyres = hasWinterTyres;
    }

    public String getTypeOfDrive() {
        return typeOfDrive;
    }

    public void setTypeOfDrive(String typeOfDrive) {
        this.typeOfDrive = typeOfDrive;
    }

    public int getMotorVolume() {
        return motorVolume;
    }

    public void setMotorVolume(int motorVolume) {
        this.motorVolume = motorVolume;
    }

    @Override
    public String getAdText() {
        if (isHasWinterTyres()) {
            return String.format("%s %s, årsmodell %d.\nVinterdäck ingår!\n%s, motorvolym är %d cm3.\n%s, %d mil, endast %d kr! \n%s\n",
                    getHeading(), getBrandModel(), getModelYear(), getTypeOfDrive(),
                    getMotorVolume(), getColor(), getDistanceTravelled(), getPrice(), getDescription());
        } else {
            return String.format("%s %s, årsmodell %d.\n%s, motorvolym  är %d cm3.\n%s, %d mil, endast %d kr! \n%s\n",
                    getHeading(), getBrandModel(), getModelYear(), getTypeOfDrive(),
                    getMotorVolume(), getColor(), getDistanceTravelled(), getPrice(), getDescription());
        }
    }

    @Override
    public String getHeader() {
        return String.format("%s %s, %d kr!\n", getHeading(), getBrandModel(), getPrice());
    }

    public static MotorcycleAd createMotorcycleAd() {
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
        success = false;
        while (!success) {
            System.out.print("Ange motorvolym: ");
            input = in.nextLine();
            if (WelcomeMenu.tryParse(input)) {
                success = true;
            } else success = false;
        }
        int motorVolume = Integer.parseInt(input);
        System.out.print("Ange drifttyp (kardan, kedja etc): ");
        String typeOfDrive = in.nextLine();
        System.out.print("Har motorcykeln vinterdäck: (j/n)  ");
        String hasTyresString = in.nextLine();
        boolean hasTyres = false;
        if (hasTyresString.equalsIgnoreCase("j")) {
            hasTyres = true;
        }

        return new MotorcycleAd(header, brandModel, modelYear, color, distance, price, description, motorVolume, typeOfDrive, hasTyres);
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
        return getPrice()/1.25*0.9;
    }
}
