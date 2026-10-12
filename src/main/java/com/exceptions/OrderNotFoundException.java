package com.exceptions;

public class OrderNotFoundException extends RuntimeException {
    //от класса RuntimeException удобнее наследовать своё исключение, чтобы не заставлять всюду писать try/catch
    //на вход передать логичный параметр, например номер заказа, чтобы быстрее отследить ошибку
    //super - для возвращения значения в родительский класс

    //это КОНСТРУКТОР класса OrderNotFoundException
    public OrderNotFoundException(int orderId) {
        super("OrderNotFound with id=" + orderId);
    }
}
