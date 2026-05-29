package machine;
import java.util.Scanner;
public class CoffeeMachine {
    static int water = 400;
    static int milk = 540;
    static int beans = 120;
    static int cups = 9;
    static int money = 550;
    static int coffeeCounter = 0;
    static SortOfCoffee espresso = new SortOfCoffee(250, 0, 16, 4);
    static SortOfCoffee latte = new SortOfCoffee(350, 75, 20, 7);
    static SortOfCoffee cappucino = new SortOfCoffee(200, 100, 12, 6);
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        runMenu();
    }
    static void runMenu() {
        while (true) {
            System.out.println("Write action (buy, fill, take, clean, remaining, exit)");
            String action = scanner.nextLine();
            switch (action) {
                case "buy":
                case "1":
                    if (coffeeCounter >=10) {
                        System.out.println("I need cleaning!");
                    }else {
                    buy();
                    }
                    break;
                case "fill":
                case "2":
                    fill();
                    break;
                case "take":
                case"3":
                    takeMoney();
                    break;
                case "clean":
                case"4":
                    cleanMachine();
                    break;
                case "remaining":
                case "5":
                    printState();
                    break;
                case "exit":
                case "6":
                    return;
            }
        }
    }
    static void buy() {
            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
            String action = scanner.nextLine();
            switch (action) {
                case "1":
                    makeCafee(espresso);
                    break;
                case "2":
                    makeCafee(latte);
                    break;
                case "3":
                    makeCafee(cappucino);
                    break;
                case "back":
                case "4":
                    return;
            }

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
    static void cleanMachine() {
        System.out.println("I have been cleaned!");
        coffeeCounter = 0;
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
    static void makeCafee(SortOfCoffee coffee) {
        /*if (coffeeCounter >=10) {
            System.out.println("I need cleaning!");
            return;
        }*/
        if (water < coffee.water) {
            System.out.println("Sorry, not enough water!");
            return;
        }
        if (milk < coffee.milk) {
            System.out.println("Sorry, not enough milk!");
            return;
        }
        if (beans < coffee.beans) {
            System.out.println("Sorry, not enough coffee beans!");
            return;
        }
        if (cups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
            return;
        }
        System.out.println("I have enough resources, making you a coffee!");
        water -= coffee.water;
        milk -= coffee.milk;
        beans -= coffee.beans;
        cups--;
        money += coffee.price;
        coffeeCounter ++;
    }
}
class SortOfCoffee{
    int water;
    int milk;
    int beans;
    int price;
    SortOfCoffee(int w, int m, int b, int p){
        this.water = w;
        this.milk = m;
        this.beans = b;
        this.price = p;
    }
}
