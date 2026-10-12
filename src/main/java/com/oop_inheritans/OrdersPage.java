package com.oop_inheritans;

public class OrdersPage extends BasePage {
    protected OrdersPage(String baseUrl) {
        super(baseUrl);
    }

    @Override
    public String url() {
        return baseUrl + "/orders";
    }

    @Override
    public String readySelector() {
        return "[data-testId=order-list]";
    }
}
