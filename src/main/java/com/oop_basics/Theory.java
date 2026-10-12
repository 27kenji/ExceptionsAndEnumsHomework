package com.oop_basics;

public class Theory {
    public static void main(String[] args) {
        OrderResponse orderResponse = new OrderResponse();
        System.out.println(orderResponse.getId());

        //конструкторы при создании объекта класса позволяют сразу передать все значения переменных класса
        //(поля, которые указываем вверху класса)
        //чтобы не присваивать значения переменных через сеттеры, типа:
        //orderResponse.setId(2) и так для каждой переменной
        OrderResponse orderResponse1 = new OrderResponse(5, 123, "REJECTED", 23.56);
        System.out.println(orderResponse1.getId());

        orderResponse.summary();
        orderResponse1.summary();
        orderResponse.addDiscount(34);
        System.out.println(orderResponse.getPrice());

        //но если есть пустой конструктор, то при созданни объекта класса придется все равно задвать значения полям класса
        //если значения полей нужны будут при вызове методов этого класса (часть полей может не использоваться)
    }

}
