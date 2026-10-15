package com.base.assertJ;

import org.junit.jupiter.api.Test;

//assertj вспомогательная библиотека для junit, которая позволяет расширить проверки и добавляет множество заготовок
//используется точка входа assertThat и assertSoftly, на вход подается аргумент (объект проверки, может иметь тип числа, строки, списка, люъекта), и дальше через .
//вызывается весь список доступных методов для проверки
//Fluent API позволяет использовать цепочки методов вместо множества assertEquals, каждый метод возвращает self

import static org.assertj.core.api.Assertions.assertThat;

public class HelloAssertJTest {
    @Test
    public void test1() {
        int quantity = 5;

        assertThat(quantity).isPositive();
        assertThat(quantity).isGreaterThan(1);
        assertThat(quantity).isEqualTo(5);
        assertThat(quantity).isLessThan(10);
    }

    @Test
    public void test2() {
        String jwtToken = "Bearer fjhe.jhr6j5h6.jhtgjfhgj";

        assertThat(jwtToken).contains("Bearer");
        assertThat(jwtToken).isNotBlank();
        assertThat(jwtToken).contains("fjhe.");
    }

    @Test
    public void test3() {
        String status = "PAID";

        assertThat(status)
                .isNotNull()
                .isEqualTo("PAID")
                .hasSize(4);
    }



}
