package com.oop_homework;

public class Drink extends MenuItem{

    Drink(String name, int basePrice) {
        super(name, basePrice);
    }

    @Override
    int price() {
        return basePrice;
    }

    @Override
    String kind() {
        return "Напиток";
    }
}
