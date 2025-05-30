package com.pluralsight.model;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private List<Chips> chips = new ArrayList<>();

    public Order() {
        this.sandwiches = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chips = new ArrayList<>();
    }

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addChips(Chips chips1) {
        chips.add(chips1);
    }

    public String showOrder() {
        StringBuilder builder = new StringBuilder();

        System.out.println("===== Order Details =====");
        builder.append("===== Order Details =====" + "\n");
        for (Sandwich sandwich : sandwiches) {
            String messageSandwich = sandwich.showDetails();
            builder.append(messageSandwich + "\n");
        }
        for (Drink drink : drinks) {
            System.out.println("Drink: " + drink.getFlavor() + " - $" + drink.getPrice());
            builder.append("Drink: " + drink.getFlavor() + " - $" + drink.getPrice() + "\n");
        }
        for (Chips chips1 : chips) {
            System.out.println("Chips: " + " - $" + chips1.getPrice("no"));
            builder.append("Chips: " + " - $" + chips1.getPrice("no") + "\n");
        }
        System.out.println("-----------------------------");
        builder.append("-----------------------------" + "\n");

        return builder.toString();
    }

    public void cleanList() {
        this.sandwiches = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chips = new ArrayList<>();
    }
}
