package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        //calCoffee();

        cupsOfCoffee();

    }

    static void calCoffee() {
        int numOfCups, water = 200, milk = 50, cofBeans = 15;

        System.out.println("Write how many cups of coffee you will need:");
        numOfCups = input.nextInt();

        water *= numOfCups;
        milk *= numOfCups;
        cofBeans *= numOfCups;

        System.out.println("For " + numOfCups + " cups of coffee you will need:\n" +
                +water + " ml of water\n" +
                +milk + " ml of milk\n" +
                +cofBeans + " g of coffee beans\n");
    }


    static void cupsOfCoffee() {

        //Declare quantity of ingredient required to make a cup of Coffee
        final int waterRequired = 200, milkRequired = 50, cofBeansRequired = 15;

        //Variable to hold user input
        int numOfCups, water, milk, cofBeans;

        //Declare variable to hold quantity of cups that can be made and ingredient
        //Initialise so values can be added.
        int serveWater =0, serveMilk =0, serveCofBeans =0;

        //Maximum cups of coffee that can be made based on cups and ingredient provided
        int cupMax;


        //Get user input
        System.out.println("Write how many ml of water the coffee machine has:");
        water = input.nextInt();

        System.out.println("Write how many ml of milk the coffee machine has:");
        milk = input.nextInt();

        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        cofBeans = input.nextInt();

        System.out.println("Write how many cups of coffee you will need:");
        numOfCups = input.nextInt();

        //Compare ingredient provided to required ingredient to determine quantity that can be made
        if ((water >= waterRequired) && (milk >= milkRequired) && (cofBeans >= cofBeansRequired)) {
            serveWater = water / waterRequired;
            serveMilk = milk / milkRequired;
            serveCofBeans = cofBeans / cofBeansRequired;
        }

        //get maximum cups of coffee that can be made by taking the smallest of the three served values
        cupMax = Math.min(Math.min(serveWater, serveMilk), serveCofBeans);

        //Display cups of coffee that can be made
        if (numOfCups > cupMax) {
            System.out.print("No, I can make only " + cupMax + " cup(s) of coffee");
        } else if (numOfCups < cupMax) {
            System.out.print("Yes, I can make that amount of coffee (and even " + (cupMax - numOfCups) + " more than that)");
        } else {
            System.out.print("Yes, I can make that amount of coffee");
        }

    }
}
