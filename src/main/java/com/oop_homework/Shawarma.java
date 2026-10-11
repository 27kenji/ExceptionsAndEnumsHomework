package com.oop_homework;

public class Shawarma extends MenuItem{
    private final boolean xl;

    Shawarma(String name, int basePrice, boolean xl) {
        super(name,basePrice);
        this.xl = xl;
    }

    @Override
    public int price() {
        if(xl) {
            return basePrice + 100;
        }
        return basePrice;
    }

    @Override
    public String kind() {
        return "Шаурма";
    }
}
