package com.enums;

public class Theory {

    /*
    Enum - это перечисления, которые НЕ являются строкой (но под капотом это строка), числом и т.д. Когда у поля несколько вариантов значений - используется enum.
    Он фиксированный - все возможные значения известны заранее. Например, известные зарнее статусы, варианты сортировки. Опечатки в коде ловятся сразу,
    он фиксируемый, безопасный и читаемый.
    Можно сравнивать через ==.
    Методы:
    values() - получить массив из всех перечислений
    name() - выводит имя как строку
    valueOf() - конвертировать из строки в enum
    Enum могут поддерживать конструкторы, это полноценный класс. Помимио этого, нужно создать приватные финальные поля и геттеры/сеттеры.
    */

    public static void main(String[] args) {
        //создаем экземпляр enum (НЕ через new)
        OrderStatus orderStatus = OrderStatus.PAID;

        if(orderStatus == OrderStatus.PAID) {
            System.out.println("Заказ оплачен");
        }

        //простой enum
        //через switch перебираем все enum на соответствие входящей переменной s, -> присваивает переменной hint значение (но после -> могут вызываться другие методы)
        OrderStatus s = OrderStatus.PREPARING;
        String hint = switch (s) {
            case CREATED, AWAITING_PAYMENT -> "ждем оплату";
            case PAID, PREPARING -> "готовим";
            case READY, COMPLETED -> "можно выдавать";
            case CANCELLED -> "отменен";
        };

        System.out.println(hint);

        //enum с конструктором
        PaymentChoice crypto = PaymentChoice.CRYPTO;
        System.out.println(crypto.getProvider());

        //DEBUGGER
        //ставим красную точку на строчки и запускаем программу, она остановится на выбранных строках. Для поэтапного выполнения кода
    }

}
