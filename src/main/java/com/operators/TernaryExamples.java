package com.operators;

public class TernaryExamples {
    public static void main(String[] args) {
        String env = "LOCAL";
        String baseUrl = env.equals("LOCAL") ? "google.com" : "yandex.ru";
        System.out.println(baseUrl);
    }
}
