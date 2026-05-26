package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water the coffee machine has:");
        int waterAmount = scanner.nextInt();

        System.out.println("Write how many ml of milk the coffee machine has:");
        int milkAmount = scanner.nextInt();

        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int beansAmonunt = scanner.nextInt();

        System.out.println("Write how many cups of coffee you will need:");
        int cups = scanner.nextInt();


        int maxWwater = waterAmount / 200;
        int maxMilk = milkAmount / 50;
        int maxBeans = beansAmonunt / 15;

        int possibleCoffees2 = Math.min(Math.min(maxWwater, maxMilk), maxBeans);

        if(cups == possibleCoffees2){
            System.out.println("Yes, I can make that amount of coffee");
        }else if(cups < possibleCoffees2){
            System.out.println("Yes, I can make that amount of coffee (and even " + (possibleCoffees2 - cups)
                                + " more than that)" );
        }else{
            System.out.println("No, I can make only " + possibleCoffees2 + " cup(s) of coffee");
        }

    }

}




