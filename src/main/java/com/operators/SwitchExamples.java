package com.operators;

public class SwitchExamples {
    public static void main(String[] args) {
        String baseUrl = "";
        String env = "LOCAL";

        //SWITCH

        //когда нужно сравнить одну переменную со множеством вариантов. Читается проще, чем длинная цепочка if-else
        //на вход передается какое-то значение и в зависимости от этого значения выполняется соответствующая логика
        //На практике используется при написании фабрик; принимает на вход типы данных String, int, enum
        baseUrl = switch (env) {
            case "LOCAL" -> "localhost:8080";
            case "PROD" -> "https://google.com";
            case "STAGE" -> "https://yandex.ru";
            default -> baseUrl;
        };
        System.out.println(baseUrl);
    }
}
