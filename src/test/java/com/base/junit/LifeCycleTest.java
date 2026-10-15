package com.base.junit;

import org.junit.jupiter.api.*;

public class LifeCycleTest {

    private int counter;

    //методы в @BeforeAll должны быть статичными, не хранить состояние. Эти методы будут работать только с классом в целом и не будут менять состояние тестов
    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before all");
    }

    //@BeforeEach запускается заново перед каждым тестом, поэтому состояние полей сбрасывается — тесты не влияют друг на друга. Это и есть изоляция тестов
    @BeforeEach
    public void setUp() {
        System.out.println("Сброс счетчика до дефолтного значения");
        counter = 10;
    }

    @AfterEach
    public void tearDown() {
        System.out.println("After each");
    }

    @Test
    public void firstTest() {
        System.out.println("Это первый тест");
        counter = counter + 5;
        Assertions.assertEquals(15, counter);
    }

    @Test
    public void secondTest() {
        System.out.println("Это второй тест");
        Assertions.assertEquals(10, counter);
    }

}
