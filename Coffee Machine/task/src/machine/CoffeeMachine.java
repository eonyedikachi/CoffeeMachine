package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static Scanner input;

    static int water = 400, milk = 540, cofBeans = 120, dispCups = 9, money = 550;
     static boolean confirmCheck;

    public static void main(String[] args) {

        //coffee();
       

        input = new Scanner(System.in);

        boolean exit = false;

        //execute until user enters "exit"

        do{

            System.out.println("Write action (buy, fill, take, remaining, exit):");
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

                case "remaining":
                    remaining();
                    break;
                case "exit":
                    exit = true;
                    break;
            }
            System.out.println("");

        } while(!exit);

    }

    //Stage 2 Task
    static void calCoffee() {
        input = new Scanner(System.in);
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
        input = new Scanner(System.in);

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
    //Display Coffee Resources Remaining
    static void remaining(){
        System.out.println();

        if(money >0) {
            System.out.println("The coffee machine has:\n" +
                    water + " of water\n" +
                    milk + " of milk\n" +
                    cofBeans + " of coffee beans\n" +
                    dispCups + " of disposable cups\n$" +
                    money + " of money");
        } else{
            System.out.println("The coffee machine has:\n" +
                    water + " of water\n" +
                    milk + " of milk\n" +
                    cofBeans + " of coffee beans\n" +
                    dispCups + " of disposable cups\n" +
                    money + " of money");
        }
        System.out.println();
    }

    //Buy Coffee
    static void buy(){

        input = new Scanner(System.in);

        int waterRequired, milkRequired, cofBeansRequired, dispcupsRequired;
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String buy = input.next();

        buy = buy.trim();// To remove possible white spaces
        switch (buy){
            case "1":{
            waterRequired = 250;
            cofBeansRequired = 16;
            dispcupsRequired = 1;
            milkRequired = milk;

            //Check if Resource is enough to make Espresso
                confirmCheck = checkResources(waterRequired, milkRequired, cofBeansRequired, dispcupsRequired);

                if(confirmCheck){
                    water -= waterRequired;
                    cofBeans -= cofBeansRequired;
                    dispCups -= dispcupsRequired;
                    money += 4;
                }
         }break;
            case "2": {
                waterRequired = 350;
                cofBeansRequired = 20;
                milkRequired = 75;
                dispcupsRequired =  1;

                //Check if Resource is enough to make Latte
                confirmCheck = checkResources(waterRequired, milkRequired, cofBeansRequired, dispcupsRequired);

                if(confirmCheck){
                    water -= waterRequired;
                    cofBeans -= cofBeansRequired;
                    milk -= milkRequired;
                    dispCups -= 1;
                    money += 7;
                }
            }break;
            case "3": {
                waterRequired = 200;
                cofBeansRequired = 12;
                milkRequired = 100;
                dispcupsRequired = 1;

                //Check if Resource is enough to make Cappuccino
                confirmCheck = checkResources(waterRequired, milkRequired, cofBeansRequired, dispcupsRequired);

                if(confirmCheck){
                    water -= waterRequired;
                    cofBeans -= cofBeansRequired;
                    milk -= milkRequired;
                    dispCups -= dispcupsRequired;
                    money += 6;
                }
            }break;
            case "back":
            default: {
                break;
            }
        }


        System.out.println();


    }

    //Refill Coffee Resources
    static void fill(){

        input = new Scanner(System.in);

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

        System.out.println();

    }


    //Take money in Coffee Machine Storage
    static void take(){
        System.out.println();
        System.out.println("I gave you $" + money);
        money =0;
        System.out.println("");
    }

    static boolean checkResources(int waterRequired, int milkRequired, int cofBeansRequired, int dispcupsRequired) {

        if (water >= waterRequired) {
            if (milk >= milkRequired) {
                if (cofBeans >= cofBeansRequired) {
                    if(dispCups >= dispcupsRequired){
                    System.out.println("I have enough resources, making you a coffee!");
                    return true;
                    }
                    else {
                    System.out.println("Sorry, not enough disposable cups!");
                    return false;
                    }
                }
                else{
                        System.out.println("Sorry, not enough coffee beans!");
                        return false;
                    }

            } else {
                System.out.println("Sorry, not enough milk!");
                return false;
            }
        } else {
            System.out.println("Sorry, not enough water!");
            return false;
        }

    }
    //End of Stage 4 Task
}

