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
public class CarAd extends VehicleAd {

    static Scanner in = new Scanner(System.in);

    private boolean hasSummerTyres;
    private boolean hasWinterTyres;

    public CarAd(String heading, String brandModel, int modelYear, String color, int distanceTravelled, int price, String description, boolean hasSummerTyres, boolean hasWinterTyres) {
        super(heading, brandModel, modelYear, color, distanceTravelled, price, description);
        this.hasSummerTyres = hasSummerTyres;
        this.hasWinterTyres = hasWinterTyres;
    }

    public boolean isHasSummerTyres() {
        return hasSummerTyres;
    }


    public boolean isHasWinterTyres() {
        return hasWinterTyres;
    }


    @Override
    public String getAdText() {
        if (isHasSummerTyres() && isHasWinterTyres()) {
            return String.format("%s %s, årsmodell %d.\nSommardäck och vinterdäck ingår!\n%s, %d mil, endast %d kr!\n%s\n",
                    getHeading(), getBrandModel(), getModelYear(), getColor(), getDistanceTravelled(), getPrice(), getDescription());
        } else if (isHasSummerTyres()) {
            return String.format("%s %s, årsmodell %d.\nSommardäck ingår!\n%s, %d mil, endast %d kr!\n%s\n",
                    getHeading(), getBrandModel(), getModelYear(), getColor(), getDistanceTravelled(), getPrice(), getDescription());
        } else if (isHasWinterTyres()) {
            return String.format("%s %s, årsmodell %d.\nVinterdäck ingår!\n%s, %d mil, endast %d kr!\n%s\n",
                    getHeading(), getBrandModel(), getModelYear(), getColor(), getDistanceTravelled(), getPrice(), getDescription());
        } else {
            return String.format("%s %s, årsmodell %d.\nBilen saknar däck, men det kan köpas till för en låg kostnad!\n%s, %d mil, endast %d kr! \n%s\n",
                    getHeading(), getBrandModel(), getModelYear(), getColor(), getDistanceTravelled(), getPrice(), getDescription());
        }
    }

    @Override
    public String getHeader() {
        return String.format("%s %s, %d kr!\n", getHeading(), getBrandModel(), getPrice());

    }

    public static CarAd createCarAd() {
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
        System.out.print("Har bilen sommardäck: (j/n)  ");
        String hasTyresString = in.nextLine();
        boolean hasSummerTyres = false;
        if (hasTyresString.equalsIgnoreCase("j")) {
            hasSummerTyres = true;
        }
        System.out.print("Har bilen vinterdäck: (j/n)  ");
        hasTyresString = in.nextLine();
        boolean hasWinterTyres = false;
        if (hasTyresString.equalsIgnoreCase("j")) {
            hasWinterTyres = true;
        }
        return new CarAd(header, brandModel, modelYear, color, distance, price, description, hasSummerTyres, hasWinterTyres);
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
