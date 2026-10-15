package com.base.junit;

import org.junit.jupiter.api.*;

//аннтоция над классом для отображения читаемого названия
@DisplayName("Примеры тестов с аннотациями")

public class DisplayNameAndTagsTest {

    @Test
    @Tag("smoke") // метка для группировки в CI
    @DisplayName("Смоук проверка на сумму")
    public void test1() {
        Assertions.assertEquals(4, 2+2);
    }

    @Test
    @Tag("regress")
    @DisplayName("Долгая проверка: умножение работает")

    public void test2() {
        Assertions.assertEquals(20, 2*10);
    }

    @Test
    @Disabled("Will be fixed after my vacation") //временно выключает тест
    public void test3() {
        //body
    }

}
