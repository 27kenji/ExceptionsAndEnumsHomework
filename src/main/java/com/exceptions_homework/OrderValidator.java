package com.exceptions_homework;

public class OrderValidator {
    public static void main(String[] args) {
        runCase(0,  RecipeSize.M, 2,  PaymentChoice.CARD);
        runCase(42, null,         2,  PaymentChoice.CARD);
        runCase(42, RecipeSize.L, 15, PaymentChoice.CARD);
        runCase(42, RecipeSize.L, 2,  null);
        runCase(42, RecipeSize.L, 5,  PaymentChoice.CASH);
        runCase(42, RecipeSize.L, 2,  PaymentChoice.CARD);
    }

    static int validateAndPrice(long recipeId, RecipeSize size, int qty, PaymentChoice payment) {
        if(recipeId <= 0) {
            throw new OrderValidationException("recipeId must be positive");
        }
        if(size == null) {
            throw new OrderValidationException("size is required");
        }
        if(qty < 1 || qty > 10) {
            throw new OrderValidationException("qty must be between 1 and 10");
        }
        if(payment == null) {
            throw new OrderValidationException("payment is required");
        }

        int total = size.getBasePrice() * qty;

         if(total > 1000 && !payment.isOnline()){
             throw new OrderValidationException("cash not allowed for orders over 1000");
         }
         else {
             return total;
         }
    }

    private static void runCase(long recipeId, RecipeSize size, int qty, PaymentChoice payment) {
        try {
            int price = validateAndPrice(recipeId, size, qty, payment);
            System.out.println("[OK] price=" + price);
        }
        catch (OrderValidationException e) {
            System.out.println("[REJECT] " + e.getMessage());
        }
    }
}