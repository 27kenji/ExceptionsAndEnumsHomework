package com.lambdas_streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupExamples {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order(1L, "CREATED", 150.0, "Alice"),
                new Order(2L, "PAID", 320.99, "Bob"),
                new Order(3L, "CANCELLED", 89.76, "Alice"),
                new Order(4L, "PAID", 210.00, "Charlie"),
                new Order(5L, "PAID", 540.90, "Bob")
        );

        //группировка через стримы, фомартирование из List в Map
        Map<String, List<Order>> collect = orders.stream()
                .collect(Collectors.groupingBy(x -> x.getCustomer()));
        System.out.println(collect);

        Map<String, Long> collect1 = orders.stream()
                .collect(Collectors.groupingBy(x -> x.getCustomer(), Collectors.counting()));
        System.out.println(collect1);


    }
}
