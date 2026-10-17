package com.base.lombok;
/*
Lombok - библиотека, с помощью которой через аннотации можно генерировать геттеры, сеттеры, конструкторы, переопределять методы toString, equals, hashCode и
создавать билдеры, т.е. собирать большие объекты опционально. Все методы создаются на этапе компиляции
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

//включет в себя аннотации @Getter + @Setter + @ToString + @EqualsAndHashCode + @RequiredArgsConstructor
@Data
//создаем несколько конструкторов, один со всеми аргументами, другой без них (). Создать объект класса можно будет 2 способами
@AllArgsConstructor
//@NoArgsConstructor

//эта аннотация эквивалентна конструктору с заполненным полем (будет использована для final поля)
@RequiredArgsConstructor

//собирает весь объект
@Builder
public class Order {
    private Integer id;
    private String status;
    private Double price;

    //финальные поля всегда инициализируется через конструктор, т.к. значение для них задается один раз и не меняется
    private final String orderName;

}
