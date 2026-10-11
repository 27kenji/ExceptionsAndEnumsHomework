package com.oop_homework;

public interface Discountable {
    int discountPercent();

    default int applyDiscount(int amount) {
        return amount - amount * discountPercent() / 100;
    }
}
