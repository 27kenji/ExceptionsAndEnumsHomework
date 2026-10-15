package com.base.assertJ;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

public class CollectionsAssertjTest {
    @Test
    public void test1() {
        List<String> paid = List.of("PAID", "CREATED", "PREPARING");

        assertThat(paid)
                .as("Список с доступными статусами")
                .hasSize(3)
                .doesNotContain("DONE")
                .contains("PAID")
                //проверка, что каждый элемент списка при возведении в верхний регситр равен этому же элементу без возведения в верхний регистр
                .allMatch(x -> x.toUpperCase().equals(x));
    }

    //assertSoftly выполнит все проверки, а assertThat упадет при прогоне на первой полученной ошибке

    /*
Как понять, что можно использовать лямбду:
Есть метод allMatch.
IDE (IntelliJ/Eclipse) подсвечивает параметр и подсказывает: «здесь можно поставить лямбду».
Ты наводишь курсор на allMatch → видишь Predicate<? super ELEMENT>.
Вспоминаешь: Predicate — функциональный интерфейс. Значит, лямбда подходит.
То есть не ты решаешь, где применить лямбду. Ты смотришь на сигнатуру метода и видишь, что автор API её там предусмотрел.
    */

    @Test
    public void test2() {
        List<String> paid = List.of("PAID", "CREATED", "PREPARING");

        assertSoftly(x -> {
            x.assertThat(paid).hasSize(4);
            x.assertThat(paid).contains("DONE");
            x.assertThat(paid).doesNotContain("CANCELLED");
        }
        );

        // allSatisfy — проверка, верная для КАЖДОГО элемента
        assertThat(paid).allSatisfy(o ->
                assertThat(o.contains("CANCELLED")));
    }

}
