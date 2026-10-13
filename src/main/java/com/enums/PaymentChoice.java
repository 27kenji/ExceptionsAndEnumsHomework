package com.enums;

public enum PaymentChoice {
    CARD("VISA", true),
    CASH("InHouse", false),
    CRYPTO("Binance", true);

    //нужно обозначить финальные переменные, которые потом попадут в конструктор
    //final поля обязательно должны быть инициализированы при объявлении или через конструктор
    private final String provider;
    private final boolean online;

    //конструктор
    PaymentChoice(String provider, boolean online) {
        this.provider = provider;
        this.online = online;
    }

    //нужно сгенерировать геттеры, чтобы доставать значения полей enum

    public boolean isOnline() {
        return online;
    }

    public String getProvider() {
        return provider;
    }
}
