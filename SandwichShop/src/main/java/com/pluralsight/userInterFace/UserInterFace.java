package com.pluralsight.userInterFace;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInterFace {

    public void homeScreen() {

        Scanner scanner = new Scanner(System.in);
        Boolean exit = false;


        do {
            int option;
            try {
                System.out.println("""
                        Welcome to Delicious shop
                        =======================
                        1) New Order
                        0) Exit
                        Select an option:
                        """);

                option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1 -> orderScreen(scanner);
                    case 0 -> exit = true;
                    default -> System.out.println("Please select a valid option");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please digit a numeric option!");
                scanner.nextLine();
            }
        } while (!exit);


    }

    private void orderScreen(Scanner scanner){

        boolean repeatError = false;

        do {
            try {
                System.out.println("""
                        Make your order
                        =======================
                        1) Add Sandwich
                        2) Add Drink
                        3) Add Chips
                        4) Checkout
                        0) Cancel order
                        """);
                int optionOrder = scanner.nextInt();
                scanner.nextLine();

                switch (optionOrder) {
                    case 1 -> System.out.println("add Sandwich ");
                    case 2 -> System.out.println("add Drink ");
                    case 3 -> System.out.println("add Chips ");
                    case 4 -> System.out.println("add Checkout ");
                    case 0 -> repeatError = true;

                    default -> System.out.println("Please select a valid option");

                }

            } catch (InputMismatchException e) {
                System.out.println("Please digit a numeric option!");
                scanner.nextLine();
            }
        } while (!repeatError);


    }
    private void addSandwich(Scanner scanner){
        System.out.println("Select your bread (white, wheat,rye,wrap): ");
        String typeBread = scanner.nextLine();
        System.out.println("Please select the size(4\",8\",12\")");
        String inches = scanner.nextLine();
        System.out.println("select your toppings");
        System.out.println("--------------------");
        System.out.println("select your meat type (steak,ham,salami,roast beef,chicken,bacon)");
        String meatChoice = scanner.nextLine();
        System.out.println("select your type of cheese (american, provolone, cheddar,swiss)");
        String cheeseChoice = scanner.nextLine();
        System.out.println("Do you want to add regular toppings? (yes/no)");
        String optionTopping = scanner.nextLine();

        if (optionTopping.equalsIgnoreCase("yes")){

            List<String> regularToppings = new ArrayList<>();
            boolean exitToppings = false;

            do {
                System.out.println("""
                        write your topping:
                        - lettuce
                        - peppers
                        - onions
                        - tomatoes
                        - jalapeños
                        - cucumbers
                        - pickles
                        - guacamole
                        - mushrooms
                        """);
                String yourToppingChoice = scanner.nextLine();
                regularToppings.add(yourToppingChoice);
                System.out.println("Do you want another topping? (yes or not)");
                String anotherTopping = scanner.nextLine();
                exitToppings = anotherTopping.equalsIgnoreCase("yes") ? true : false;
            }while (!exitToppings);
        }

        System.out.println("Do you want sauces? (yes or not)");
        String addSauces = scanner.nextLine();

        if (addSauces.equalsIgnoreCase("yes")){

            List<String> sauces = new ArrayList<>();
            boolean exitSauces = false;

            do {
                System.out.println("""
                        - mayo
                        - mustard
                        - ketchup
                        - ranch
                        - thousand islands
                        - vinaigrette
                        """);
                String yourSauceChoice = scanner.nextLine();
                sauces.add(yourSauceChoice);
            }while (!exitSauces);
        }


    }
}
