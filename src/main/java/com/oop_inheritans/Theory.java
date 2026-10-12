package com.oop_inheritans;

public class Theory {
    public static void main(String[] args) {
        //абстракция - выделяем общие свойства и запрещаем создавать общие методы, объекты класса можно создавать через что-то конкретное
        //например, отдельные классы-наследники

        //нельзя создавть объект класса BasePage, поэтому создаем объекты классов-наследников BasePage
        //у экземплятор классов-наследников доступны их личные методы и методы класса-родителя
        LoginPage loginPage = new LoginPage("https://google.com");
        OrdersPage ordersPage = new OrdersPage("https://google.com");

        System.out.println(loginPage.readySelector());
        System.out.println(ordersPage.readySelector());

        loginPage.open();
        loginPage.waitLoaded();
        loginPage.enterCredentials("test@mail.ru", "Password123");

        ordersPage.waitLoaded();

        //создается объект класса Plane
        Plane plane = new Plane();
        //у созданного объекта можно вызвать метод класса Plane или уже реализованные методы интерфейса
        //не нужен sout, т.к. в методе уже реализован вывод в консоль
        plane.fly();
        plane.startFly("Победа", 1000);
    }
}
