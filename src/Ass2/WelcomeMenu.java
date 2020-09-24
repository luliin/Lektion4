package Ass2;
import Ass2.Subclasses.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Julia Wigenstedt
 * Date: 2020-09-22
 * Time: 14:58
 * Project: Lektion3
 * Copyright: MIT
 */
public class WelcomeMenu {

    static Scanner in = new Scanner(System.in);
    static List<VehicleAd> ads = new ArrayList<>();

    public static boolean welcomeMenu() {
        System.out.println("Välj vad du vill göra:\n\n" + "1. Skapa en bilannons\n"
                + "2. Skapa en husvagnsannons\n" +
                "3. Skapa en motorcykelannons\n" +
                "4. Lista alla annonser\n" +
                "5. Lista beräknad vinst för alla fordon\n" +
                "6. Avsluta");
        String selection = in.nextLine();

        switch (selection) {
            case "1":
                ads.add(CarAd.createCarAd());
                return true;
            case "2":
                ads.add(CaravanAd.createCaravanAd());
                return true;
            case "3":
                ads.add(MotorcycleAd.createMotorcycleAd());
                return true;
            case "4":
                listAds();
                return true;
            case "5":
                listRevenue();
                return true;
            case "6":
                return !exitMenu();
            default:
                return true;
        }
    }

    public static void listAds() {
        if (ads.isEmpty()) {
            System.out.println("\nDet finns inga annonser ännu. Skapa några först!\n");
        } else {
            for (var ad : ads) {
                System.out.print(ads.indexOf(ad) + 1 + ". ");
                ad.printHeader();
            }
            System.out.println("Vill du titta närmare på någon annons?");
            if (ads.size() > 1) {
                System.out.println("Skriv 1-" + ads.size() + " eller n för nej: ");
            } else {
                System.out.println("Skriv 1 eller n för nej");
            }

            String input = in.nextLine();
            if (input.equalsIgnoreCase("n")) {
                System.out.println("\nOkej, vi går tillbaka till startmenyn!");
            } else {
                boolean success = false;
                while (!success) {
                    if (tryParse(input))
                        success = true;
                }
                int inputInt = Integer.parseInt(input);
                if (inputInt <= ads.size() && inputInt > 0) {
                    ads.get(inputInt - 1).printCompleteAd();
                } else {
                    System.out.println("\nSkriv in en giltig siffra. (1-" + ads.size() + ")");
                }
            }
        }
    }
    public static void listRevenue(){
        if(ads.isEmpty()){
            System.out.println("\nDet finns ännu inga fordon inne för försäljning!\n");
        } else {
            for( var ad: ads){
                System.out.printf("\n%s , pris: %d, vinst: %.1f\n", ad.getBrandModel(), ad.getPrice(), ad.calculateRevenue());
            }
        }
    }

    public static boolean exitMenu() {
        System.out.print("\nÄr du säker på att du vill avsluta? (j/n)  ");
        String selection = in.nextLine();
        if (selection.equalsIgnoreCase("j")) {
            System.out.println("\nTack för besöket! Välkommen åter.");
            return true;
        } else {
            System.out.println(" \nStanna så länge du vill.\n");
            return false;
        }
    }

    public static boolean tryParse(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println("\nDu måste ange en siffra!");
            return false;
        }
        return true;
    }

    public static String capitalize(String string) {
        if (string == null || string.isEmpty()) {
            return string;
        } else {
            return string.substring(0, 1).toUpperCase() + string.substring(1);
        }

    }
}

