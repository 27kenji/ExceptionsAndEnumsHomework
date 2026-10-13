package com.generics;

import java.util.Objects;

//типизированный класс
public class ApiResponse<T> {

    //поля, которые будут обязательно передаваться при создании объекта класса
    private final int statusCode;
    private final T body;

    //конструктор для инициализации полей класса
    //создать объект класса можно будет только передав значения полей
    public ApiResponse(int statusCode, T body) {
        this.statusCode = statusCode;
        this.body = body;
    }

    //геттеры
    public int getStatusCode() {
        return statusCode;
    }

    //метод, который будет проверять, что статус в пределах 200
    public boolean isOk() {
        return statusCode >= 200 && statusCode < 300;
    }

    //использование полиморфизма - нужно переопределить методы, чтобы вместо хеш-кода при запросе возвращались значения параметров, т.к. стандартный метод equals
    //будет всегда возвращать false, т.к. ссылки у ссылочных объектов всегда разные. При переопределении метода будут сравниваться значения вместо хеш-кодов

    @Override
    public String toString() {
        return "ApiResponse{" +
                "statusCode=" + statusCode +
                ", body=" + body +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ApiResponse<?> that = (ApiResponse<?>) o;
        return statusCode == that.statusCode && Objects.equals(body, that.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusCode, body);
    }
}
