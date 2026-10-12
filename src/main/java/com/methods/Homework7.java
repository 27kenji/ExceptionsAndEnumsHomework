package com.methods;

import java.util.*;

public class Homework7 {

    // 1. menuLine
    static String menuLine(String dish, int price) {
        return "%s — %d руб".formatted(dish, price);
    }

    // 2. orderTotal
    static int orderTotal(List<Integer> prices) {
        int sumOfPrices = 0;
        if (prices.isEmpty()) {
            return 0;
        }
            for (int price : prices) {
                sumOfPrices += price;
            }
            return sumOfPrices;
    }

    // 3. availableDishes
    static List<String> availableDishes(List<String> menu, Set<String> soldOut) {
        List<String> availablePositions = new ArrayList<>(menu);
        availablePositions.removeAll(soldOut);
       return availablePositions;
    }

    // 4. countOrders
    static Map<String, Integer> countOrders(List<String> orders) {
        Map<String, Integer> itemsWithCount = new HashMap<>();
        for (String item : orders) {
            itemsWithCount.put(item, itemsWithCount.getOrDefault(item, 0) + 1);
        }
        return itemsWithCount;
    }

    // 5. joinDishes
    static String joinDishes(List<String> dishes) {
        if (dishes.isEmpty()) {
            return "пусто";
        }
        return String.join(", ", dishes);
    }

    // 6. isOnMenu
    static boolean isOnMenu(List<String> menu, String dish) {
        for (String item : menu) {
            if (item.equalsIgnoreCase(dish)) {
                return true;
            }
        } return false;
    }

    public static void main(String[] args) {
        var menu = List.of("Шаурма", "Фалафель", "Кола");
        var orders = List.of("Шаурма", "Кола", "Шаурма");
        var sold = Set.of("Фалафель");
        var prices = List.of(250, 90, 250);

        // Шаурма — 250 руб
        System.out.println(menuLine("Шаурма", 250));

        // 590
        System.out.println(orderTotal(prices));

        // [Шаурма, Кола]
        System.out.println(availableDishes(menu, sold));

        // {Шаурма=2, Кола=1}
        System.out.println(countOrders(orders));

        // Шаурма, Фалафель, Кола
        System.out.println(joinDishes(menu));

        // true
        System.out.println(isOnMenu(menu, "кола"));
    }
}