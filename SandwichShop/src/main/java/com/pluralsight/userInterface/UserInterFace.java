package com.pluralsight.userInterface;


import com.pluralsight.data.ReceiptWriter;
import com.pluralsight.model.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInterFace {

    private double totalPrice = 0;
    private Order order = new Order();

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
                    case 1 -> displayOrderScreen(scanner);
                    case 0 -> exit = true;
                    default -> System.out.println("Please select a valid option");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please digit a numeric option!");
                scanner.nextLine();
            }
        } while (!exit);


    }

    private void displayOrderScreen(Scanner scanner) {

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
                    case 1 -> addSandwich(scanner);
                    case 2 -> addDrink(scanner);
                    case 3 -> addChips(scanner);
                    case 4 -> repeatError = checkOut(scanner);
                    case 0 -> repeatError = true;

                    default -> System.out.println("Please select a valid option");

                }

            } catch (InputMismatchException e) {
                System.out.println("Please digit a numeric option!");
                scanner.nextLine();
            }
        } while (!repeatError);


    }

    private void addSandwich(Scanner scanner) {
        System.out.println("Select your bread (white, wheat, rye, wrap): ");
        String typeBread = scanner.nextLine();
        System.out.println("Please select the size(4\",8\",12\")");
        String inches = scanner.nextLine();
        System.out.println("Select your toppings");
        System.out.println("--------------------");
        System.out.println("Select your meat type (steak, ham, salami, roast beef, chicken, bacon)");
        String meatChoice = scanner.nextLine();
        System.out.println("Do you want extra meat? (yes or no) ");
        String extraMeatChoice = scanner.nextLine();
        int extraMeatNumber = 0;
        if (extraMeatChoice.equalsIgnoreCase("yes")) {
            System.out.println("How many meats do you want? ");
            extraMeatNumber = scanner.nextInt();
            scanner.nextLine();
        }
        System.out.println("Select your type of cheese (american, provolone, cheddar, swiss)");
        String cheeseChoice = scanner.nextLine();
        System.out.println("Do you want extra cheese? (yes or no) ");
        String extraCheeseChoice = scanner.nextLine();
        int extraCheeseNumber = 0;
        if (extraCheeseChoice.equalsIgnoreCase("yes")) {
            System.out.println("How many slides of cheese do you want? ");
            extraCheeseNumber = scanner.nextInt();
            scanner.nextLine();
        }
        System.out.println("Do you want to add regular toppings? (yes/no)");
        String optionTopping = scanner.nextLine();

        List<String> toppings = new ArrayList<>();

        if (optionTopping.equalsIgnoreCase("yes")) {


            boolean exitToppings = false;

            do {
                System.out.println("""
                        Choose your topping:
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
                toppings.add(yourToppingChoice);
                System.out.println("Do you want another topping? (yes or no)");
                String anotherTopping = scanner.nextLine();
                exitToppings = anotherTopping.equalsIgnoreCase("yes") ? false : true;
            } while (!exitToppings);
        }

        System.out.println("Do you want sauces? (yes or no)");
        String addSauces = scanner.nextLine();

        if (addSauces.equalsIgnoreCase("yes")) {

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
                        Which sauce do you like?
                        """);
                String yourSauceChoice = scanner.nextLine();
                sauces.add(yourSauceChoice);
                System.out.println("Do you want another sauce? (yes or no) ");
                String anotherSauce = scanner.nextLine();
                exitSauces = anotherSauce.equalsIgnoreCase("yes") ? false : true;

            } while (!exitSauces);
        }
        System.out.println("Would you like the sandwich toasted? (yes or no)");
        String resultToasted = scanner.nextLine();
        boolean isToasted = resultToasted.equalsIgnoreCase("yes") ? true : false; //ternary operator

        Sandwich sandwich = new Sandwich();
        sandwich.setBreadType(typeBread);
        sandwich.setSize(inches);
        sandwich.setToasted(isToasted);
        List<PremiumTopping> premiumToppings = new ArrayList<>();

        premiumToppings.add(new PremiumTopping(meatChoice, 0, "meat"));
        premiumToppings.add(new PremiumTopping(cheeseChoice, 0, "cheese"));

        List<RegularTopping> regularToppings = new ArrayList<>();

        for (String regularTopping : toppings) {
            regularToppings.add(new RegularTopping(regularTopping));
        }

        sandwich.setToppings(new ArrayList<>());
        sandwich.getToppings().addAll(regularToppings);
        sandwich.getToppings().addAll(premiumToppings);
        totalPrice += sandwich.getPrice();

        for (PremiumTopping premiumTopping : premiumToppings) {
            if (premiumTopping.getTypePremiumTopping().equalsIgnoreCase("meat")) {
                totalPrice += premiumTopping.getPrice(inches, extraMeatNumber, premiumTopping.getTypePremiumTopping());
            } else if (premiumTopping.getTypePremiumTopping().equalsIgnoreCase("cheese")) {
                totalPrice += premiumTopping.getPrice(inches, extraCheeseNumber, premiumTopping.getTypePremiumTopping());
            }

        }

        order.addSandwich(sandwich);
        System.out.println("sandwich added! ");

    }

    private void addDrink(Scanner scanner) {
        System.out.println("Select your drink size: (small, medium or large)");
        String sizeDrink = scanner.nextLine();
        System.out.println("Select your flavor: (coke, sprite or pepsi)");
        String drinkFlavor = scanner.nextLine();

        Drink drink = new Drink(drinkFlavor, 0, sizeDrink);
        totalPrice += drink.getPrice();

        order.addDrink(drink);
        System.out.println("Drink added! ");

    }

    private void addChips(Scanner scanner) {
        System.out.println("Would you like to add chips? (yes or no)");
        String option = scanner.nextLine();

        Chips chips = new Chips(0);
        totalPrice += chips.getPrice(option);

        order.addChips(chips);
        System.out.println("Chips added! ");
    }

    private boolean checkOut(Scanner scanner) {

        String message = order.showOrder();
        System.out.println("your total is: $" + totalPrice);
        message += "\n" + "your total is: $" + totalPrice;


        System.out.println("Confirm or Cancel order: ");
        String choice = scanner.nextLine();


        if (choice.equalsIgnoreCase("confirm")) {
            System.out.println("Order confirm!");
            ReceiptWriter.saveReceipt(message);


        } else {
            System.out.println("Order canceled");
            order.cleanList();

        }
        return true;
    }

}
