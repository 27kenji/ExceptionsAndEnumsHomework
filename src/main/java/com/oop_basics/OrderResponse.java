package com.oop_basics;

//этот класс - модель объекта ответа метода в формате json
//маркер доступа private - напрямую из других классов нельзя получить или изменить значения переменных
public class OrderResponse {
    private int id;
    private String status;
    private double price;
    private int recieptId;

    //конструктор, принимающий все поля на вход
    //конструкторы при создании объекта класса позволяют сразу передать все значения переменных класса
    public OrderResponse(int recieptId, int id, String status, double price) {
        this.recieptId = recieptId;
        this.id = id;
        this.status = status;
        this.price = price;
    }

    //конструктор, можно инициализировать класс без полей
    //внутри конструктора может быть что угодно, это обычный метод, который вызывается каждый раз при создании объекта класса
    //например, явно задавать дефолтные значения полей
    public OrderResponse() {
        this.recieptId = 13;
        this.id = 0;
        this.status = "SUCCESS";
        this.price = 123.90;
    }

    //метод, который можно вызвать из экземпляра класса
    public void addDiscount(int percent) {
        boolean isValid = validateDiscount(percent);
        if (!isValid) {
            System.out.println("Скидка не применилась" + percent);
            return;
        }
        this.price = this.price + percent;
    }

    //вспомогательный приватный метод, нельзя вызвать из экземпляра класса
    private boolean validateDiscount(int percent) {
        if (percent < 0) {
            return false;
        }
        return percent <= 100;
    }

    public void summary() {
        System.out.println(status + id + price + recieptId);
    }

    //геттеры и сеттеры - для ограничения доступа к приватным полям
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRecieptId() {
        return recieptId;
    }

    public void setRecieptId(int recieptId) {
        this.recieptId = recieptId;
    }
}
