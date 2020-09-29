package Ass2;

/**
 * Created by Julia Wigenstedt
 * Date: 2020-09-22
 * Time: 14:58
 * Project: Lektion3
 * Copyright: MIT
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("\n---------Välkommen till Hederlige Harrys Bilar AB!--------- ");

        boolean running = true;
        while (running) running = WelcomeMenu.welcomeMenu();
    }
}

