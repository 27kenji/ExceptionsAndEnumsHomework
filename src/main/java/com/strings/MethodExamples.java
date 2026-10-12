package com.strings;

public class MethodExamples {
    public static void main(String[] args) {
        String googleCode = "GOOGLE-4813";
        String onlyNumbers = googleCode.substring(7);
        System.out.println(onlyNumbers);

        int numbersInt = Integer.parseInt(onlyNumbers);
        System.out.println(numbersInt + 10);

        String regex = googleCode.replaceAll("\\d+", "");
        System.out.println(regex);

        boolean empty = googleCode.isEmpty();
        System.out.println(empty);
    }
}
