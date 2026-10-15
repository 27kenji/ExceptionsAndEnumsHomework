package com.base.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParamsExampleTest {
    //методы с аннотацией @ParameterizedTest могут иметь входящие параметры в ()
    //у аннотации @ParameterizedTest в () можно указать name и в {} указать индекс переменной из метода successStatuses(), которая будет подставляться в тест. У метода
    //может быть несколько переменных, в этом примере передается только status
    @ParameterizedTest(name = "Статус заказа {0}")

    //аннотация @ValueSource используется, если на вход методу нужно передать 1 переменную
    //указываем значения в {}, которые будут подставляться внутрь теста по очереди, тесты будут запущены столько раз, сколько значений в источнике
    @ValueSource(strings = {"PAID", "PREPARING", "READY", "COMPLETED"})
    public void successStatuses(String status) {
        System.out.println(status);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,5,10})
    public void numbersPositive(int number) {
        Assertions.assertTrue(number > 0);
    }

    //аннотация @CsvSource используется, если на вход методу нужно передать НЕСКОЛЬКО переменных. Эта аннтоация сама конвертирует тип переменных, можно указывать любой
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "1, 1, 2",
            "2, 3, 5",
            "10, 10, 20",
            "0, 0, 0"
    })
    public void sumTest(int a, int b, int result) {
        Assertions.assertEquals(a+b, result);
    }

}
