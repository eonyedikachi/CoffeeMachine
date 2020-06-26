package machine;

import java.lang.invoke.SwitchPoint;
import java.util.Scanner;

public class CoffeeMachine {
    static Scanner input = new Scanner(System.in);

    static int water = 400, milk = 540, cofBeans = 120, dispCups = 9, money = 550;



    public static void main(String[] args) {
        coffee();
    }

    //Stage 2 Task
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
    //End of Stage 2 Task

    //Stage 3 Task
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
    //End of Stage 3 Task

    //Stage 4 Task
    static void coffee(){

        showInfo();
        System.out.println("");

        System.out.println("Write action (buy, fill, take): ");
        String action = input.next();

        switch (action){
            case "buy":
                buy();
            break;

            case "fill":
                fill();
                break;

            case "take":
                take();
                break;
        }

        System.out.println("");
        showInfo();


    }

    static void showInfo(){
        System.out.println("The coffee machine has:\n" +
                 water + " of water\n" +
                milk + " of milk\n" +
                cofBeans + " of coffee beans\n" +
                dispCups +" of disposable cups\n" +
                money + " of money");
    }

    static void buy(){

        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        int buy = input.nextInt();
        switch (buy){
            case 1:{
            water -= 250;
            cofBeans -= 16;
            money += 4;
            dispCups -= 1;
         }break;
            case 2: {
                water -= 350;
                cofBeans -= 20;
                milk -= 75;
                money += 7;
                dispCups -= 1;
            }break;
            case 3: {
                water -= 200;
                cofBeans -= 12;
                milk -= 100;
                money += 6;
                dispCups -= 1;
            }break;
        }

    }

    static void fill(){

        int waterFill, milkFill, cofBeansFill, dispcupsFill;

        System.out.println("Write how many ml of water do you want to add:");
        waterFill = input.nextInt();

        System.out.println("Write how many ml of milk do you want to add:");
        milkFill = input.nextInt();

        System.out.println("Write how many grams of coffee beans do you want to add:");
        cofBeansFill = input.nextInt();

        System.out.println("Write how many disposable cups of coffee do you want to add:");
        dispcupsFill = input.nextInt();

        water += waterFill;
        milk += milkFill;
        cofBeans += cofBeansFill;
        dispCups += dispcupsFill;
    }

    static void take(){

        System.out.println("I gave you " + money);
        money -= money;

    }
    //End of Stage 4 Task

}
