package com.oop_inheritans;

public class Plane implements Flyable{
    //этот класс имплементирует (реализует) интерфейс
    //override - это аннотация для переопределения метода, т.е. для собственной реализации
    @Override
    public void fly(){
        System.out.println("Самолет полетел");
    }
}
