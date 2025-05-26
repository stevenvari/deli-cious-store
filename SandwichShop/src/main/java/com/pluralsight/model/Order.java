package com.pluralsight.model;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private List<Chips> chips = new ArrayList<>();

    public void addSandwich(Sandwich sandwich){
        sandwiches.add(sandwich);
    }

    public void addDrink(Drink drink){
        drinks.add(drink);
    }

    public void addChips(Chips chips1){
        chips.add(chips1);
    }

    public double getTotal(){
        double total = 0;
        for (Sandwich sandwich : sandwiches){
            total += sandwich.getPrice();
        }
        for (Drink drink : drinks){
            total += drink.getPrice();
        }
        for (Chips chips1 : chips){
            total += chips1.getPrice();
        }
        return total;
    }

    public void showOrder(){

        System.out.println("===== Order Details =====");
        for (Sandwich sandwich : sandwiches){
            sandwich.showDetails();
        }
        for (Drink drink : drinks){
            System.out.println("Drink: " + drink.getName() + " - $" + drink.getPrice());
        }
        for (Chips chips1 : chips){
            System.out.println("Chips: " + chips1.getName() + " - $" + chips1.getPrice());
        }
        System.out.println("-----------------------------");
        System.out.println("Total Order: $" + getTotal());
    }
}
