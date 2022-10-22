package machine;

import java.util.Scanner;

public class CoffeeMachine {

    int water = 400;
    int milk = 540;
    int beans = 120;
    int cups = 9;
    int money = 550;

    int waterPerCup = 200;
    int milkPerCup = 50;
    int beansPerCup = 15;

    public void display(){
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water%n", this.water);
        System.out.printf("%d ml of milk%n", this.milk);
        System.out.printf("%d g of coffee beans%n", this.beans);
        System.out.printf("%d disposable cups%n", this.cups);
        System.out.printf("$%d of money%n%n", this.money);
    }

    public void runMachine () {
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String type = scanner.next();
            switch (type) {
                case "buy":
                    System.out.println();
                    buyAction();
                    break;
                case "fill":
                    System.out.println();
                    fillAction();
                    break;
                case "take":
                    System.out.println();
                    takeAction();
                    System.out.println();
                    break;
                case "remaining":
                    System.out.println();
                    display();
                    break;
                case "exit":
                    loop = false;
                    break;
            }
        }

    }

    public void calculator() {
        int waterCupsPossible = water / waterPerCup;
        int milkCupsPossible = milk / milkPerCup;
        int beansCupsPossible = beans / beansPerCup;

        int maxCupsPossible = water / waterPerCup;

        if (maxCupsPossible > milkCupsPossible) {
            maxCupsPossible = milkCupsPossible;
        }
        if (maxCupsPossible > beansCupsPossible) {
            maxCupsPossible = beansCupsPossible;
        }


        if (maxCupsPossible == cups) {
            System.out.println("Yes, I can make that amount of coffee ");
        } else if (cups > maxCupsPossible) {
            System.out.printf("No, I can make only %d cup(s) of coffee", maxCupsPossible);
        } else {
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)", maxCupsPossible - cups);
        }
    }


    public void buyAction () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        int a;
            try {
                a = scanner.nextInt();
            } catch (Exception e) {
                a = 4;
            }


        switch(a){
            case 1:
                if (250 > water) {
                    System.out.println("Sorry, not enough water!");
                } else if (16 > beans) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (1 > cups) {
                    System.out.println("Sorry, not enough cups!");
                } else {
                    this.water -= 250;
                    this.beans -= 16;
                    this.money += 4;
                    this.cups --;
                    System.out.println("I have enough resources, making you a coffee!");
                }
                break;
            case 2:
                if (350 > water) {
                    System.out.println("Sorry, not enough water!");
                } else if (20 > beans) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (1 > cups) {
                    System.out.println("Sorry, not enough cups!");
                } else if (75 > milk) {
                    System.out.println("Sorry, not enough milk!");
                } else {
                    this.water -= 350;
                    this.milk -= 75;
                    this.beans -= 20;
                    this.money += 7;
                    this.cups --;
                    System.out.println("I have enough resources, making you a coffee!");
                }
                break;
            case 3:
                if (200 > water) {
                    System.out.println("Sorry, not enough water!");
                } else if (12 > beans) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (1 > cups) {
                    System.out.println("Sorry, not enough cups!");
                } else if (100 > milk) {
                    System.out.println("Sorry, not enough milk!");
                } else {
                    this.water -= 200;
                    this.milk -= 100;
                    this.beans -= 12;
                    this.money += 6;
                    this.cups --;
                    System.out.println("I have enough resources, making you a coffee!");
                }
                break;
            case 4:
                break;
        }
        System.out.println();
    }

    public void fillAction () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add: ");
        this.water += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        this.milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        this.beans += scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add: ");
        this.cups += scanner.nextInt();
        System.out.println();


    }

    public void takeAction () {
        System.out.printf("I gave you $%d", this.money);
        this.money = 0;
        System.out.println();
    }

    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine();
        machine.runMachine();
    }
}
