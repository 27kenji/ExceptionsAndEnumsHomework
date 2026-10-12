package com.methods;

public class Theory {
    //в статичном классе досупен вызов только статичных методов
    public static void main(String[] args) {
        String message = "вызов из мейна";
        logStep(message);
        String url = buildUrl("https://google.com", 10);
        System.out.println(url);

        String urlFromEnv = getUrlFromEnv("STAGE");
        System.out.println(urlFromEnv);

    }

    //static у метода означает, что метод принадлежит классу, а не конкретному объекту (экземпляру) этого класса
    //Статический метод можно вызвать напрямую через имя класса не создавая объект класса

    //(String m) - это локальная переменная метода, у которой зона видимости только внутри этого метода
    public static void logStep(String m) {
        System.out.println("Логируем шаг: " + m);
    }

    //STRING BUILDER

    //можно использовать для создания строк из разных значений параметров
    //через метод append добавляем к изначально пустой строчке (при создании объекта класса) что-то новое
    public static String buildUrl(String baseUrl, int orderId) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(baseUrl);
        stringBuilder.append("/api/orders/");
        stringBuilder.append(orderId);
        //результат сборки url превращаем в строку
        String result = stringBuilder.toString();
        return result;
    }

    public static String getUrlFromEnv(String env) {
        String baseUrl = switch (env) {
            case "LOCAL" -> "localhost:8080";
            case "PROD" -> "https://google.com";
            case "STAGE" -> "https://yandex.ru";
            default -> "Unknown";
        };
        return baseUrl;
    }
}
