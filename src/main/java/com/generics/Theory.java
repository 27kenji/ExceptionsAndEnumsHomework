package com.generics;

public class Theory {
    /*
    Дженерики - это типизация для методов/классов. Без <> List хранит что попало, если есть <>, то компилятор гарантирует - в списке есть только строки (например).
    Если не указывать <>, то придется приводить типы вручную. Приведение типов — это преобразование значения одного типа данных в другой.
    Представь, что у тебя есть числовая переменная типа int (целое число), а тебе нужно передать её туда, где ожидается double (дробное число).
    Java позволяет это сделать — это и есть приведение типов.
    String first = (String) names.get(1)
    */

    public static void main(String[] args) {
        ApiResponse<String> apiResponse1 = new ApiResponse<>(200, "Some value");
        System.out.println(apiResponse1.isOk());

        ApiResponse<Void> apiResponse2 = new ApiResponse<>(500, null);
        System.out.println(apiResponse2.isOk());

        ApiResponse<Integer> apiResponse3 = new ApiResponse<>(201, 10);
        System.out.println(apiResponse3.isOk());
    }
}
