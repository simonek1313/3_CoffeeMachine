package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static int water = 400;
    static int milk = 540;
    static int beans = 120;
    static int cups = 9;
    static int money = 550;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        runMenu();
    }

    static void runMenu() {
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit)");
            String action = scanner.nextLine();

            switch (action) {
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    takeMoney();
                    break;
                case "remaining":
                    printState();
                    break;
                case "exit":
                    return;
            }
        }
    }

    static void buy() {

        //while (true) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String action = scanner.nextLine();
        switch (action) {
            case "1":
                makeEspresso();
                break;
            case "2":
                makeLatte();
                break;
            case "3":
                makeCappuccino();
                break;
            case "back":
                return;
        }
        //}
    }

    static void fill() {
        System.out.println("Write how many ml of water you want to add:");
        water += scanner.nextInt();

        System.out.println("Write how many ml of milk you want to add:");
        milk += scanner.nextInt();

        System.out.println("Write how many grams of coffee beans you want to add:");
        beans += scanner.nextInt();

        System.out.println("Write how many disposable cups you want to add:");
        cups += scanner.nextInt();

        scanner.nextLine(); // flush
    }

    static void takeMoney() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    static void printState() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(beans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
        //System.out.println();
    }

    static void makeEspresso() {
        int needWater = 250;
        int needBeans = 16;

        if (water < needWater) {
            System.out.println("Sorry, not enough water!");
            return;
        }
        if (beans < needBeans) {
            System.out.println("Sorry, not enough coffee beans!");
            return;
        }
        if (cups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
            return;
        }

        System.out.println("I have enough resources, making you a coffee!");

        water -= needWater;
        beans -= needBeans;
        cups--;
        money += 4;
    }

    static void makeLatte() {
        int needWater = 350;
        int needMilk = 75;
        int needBeans = 20;

        if (water < needWater) {
            System.out.println("Sorry, not enough water!");
            return;
        }
        if (milk < needMilk) {
            System.out.println("Sorry, not enough milk!");
            return;
        }
        if (beans < needBeans) {
            System.out.println("Sorry, not enough coffee beans!");
            return;
        }
        if (cups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
            return;
        }

        System.out.println("I have enough resources, making you a coffee!");

        water -= needWater;
        milk -= needMilk;
        beans -= needBeans;
        cups--;
        money += 7;
    }

    static void makeCappuccino() {
        int needWater = 200;
        int needMilk = 100;
        int needBeans = 12;

        if (water < needWater) {
            System.out.println("Sorry, not enough water!");
            return;
        }
        if (milk < needMilk) {
            System.out.println("Sorry, not enough milk!");
            return;
        }
        if (beans < needBeans) {
            System.out.println("Sorry, not enough coffee beans!");
            return;
        }
        if (cups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
            return;
        }

        System.out.println("I have enough resources, making you a coffee!");

        water -= needWater;
        milk -= needMilk;
        beans -= needBeans;
        cups--;
        money += 6;
    }
}