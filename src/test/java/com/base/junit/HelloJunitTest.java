package com.base.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloJunitTest {
    //каждый раз @Test создает новый экземпляр класса

    @Test
    //методы с аннотацией @Test НЕ могут иметь входящие параметры в ()
    public void TwoPlusTwoEqualsFour() {
        //arrange (подготовка тестовых данных)
        int a = 2;
        int b = 2;

        //act (действие)
        int result = a + b;

        //assert (проверка)
        Assertions.assertEquals(4, result);
    }

    //на вход метода assertTrue нужно передавать значение с типом boolean; будет проверка на то, что входящее значение == true
    @Test
    public void wordContainsAnotherWord() {
        String a = "Computer";
        boolean result = a.contains("uterr");
        Assertions.assertTrue(result, "Исходная строка %s не содержит uter".formatted(a));
    }

    /*
    еще есть методы класса Assertions:

    проверка, что код бросает исключение, + доступ к самому исключению

    IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> Integer.parseInt("not a number"));
    assertTrue(ex.getMessage().contains("not a number"));


    группируем проверки, если одна упала, остальные все равно выполнятся

    assertAll("userFields",
    () -> assertEquals("Alice", user.name()),
    () -> assertEquals(30, user.age()),
    );

    */

}
