package com.methods;

public class Overloading {
    public static void main(String[] args) {

        String baseUrl = "https://localhost:8080";
        String s1 = buildUrl(baseUrl, "/api/orders");
        String s2 = buildUrl(baseUrl, "/api/orders", 4);
        String s3 = buildUrl(baseUrl, "/api/orders", "id=5");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

    }

    //static у метода означает, что метод принадлежит классу, а не конкретному объекту (экземпляру) этого класса. Нет привязки к классу. Часто делают статичные методы у классов-
    //помощников (например, генерация тестовых данных)
    //Статический метод можно вызвать напрямую через имя класса не создавая объект класса

    //Перегрузка (Overloading) - несколько методов с одним именем, но разным набором параметров. Компилятор сам выбирает нужный
    //Метод с модификатором final нельзя переопределить, т.е. в дальнейшем изменить его логику. Если у класса указать модийикатор final - от класса нельзя будет наследоваться

    public static String buildUrl(String baseUrl, String path) {
        return baseUrl + path;
    }

    public static String buildUrl(String baseUrl, String path, int id) {
        return baseUrl + path + "/" + id;
    }

    public static String buildUrl(String baseUrl, String path, String queryParam) {
        return baseUrl + path + "?" + queryParam;
    }
}
