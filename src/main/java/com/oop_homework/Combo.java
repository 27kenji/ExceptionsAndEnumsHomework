package com.oop_homework;

public class Combo extends MenuItem implements Discountable{

    Combo(String name, int basePrice) {
        super(name, basePrice);
    }

    @Override
    public int discountPercent() {
        return 15;
    }

    @Override
    int price() {
        return basePrice;
    }

    @Override
    String kind() {
        return "Комбо";
    }
}
