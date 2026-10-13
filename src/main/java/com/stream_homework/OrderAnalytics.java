package com.stream_homework;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderAnalytics {
    public static void main(String[] args) {

        List<OrderRow> orders = List.of(
                new OrderRow(1, "Mike", OrderStatus.PAID, PaymentChoice.CARD, 320.00),
                new OrderRow(2, "Joe", OrderStatus.CANCELLED, PaymentChoice.CASH, 560.50),
                new OrderRow(3, "Rob", OrderStatus.COMPLETED, PaymentChoice.CRYPTO, 1200.00),
                new OrderRow(4, "Brad", OrderStatus.CREATED, PaymentChoice.CASH, 567.90),
                new OrderRow(5, "Dave", OrderStatus.READY, PaymentChoice.CASH, 560.00),
                new OrderRow(6, "Angel", OrderStatus.PREPARING, PaymentChoice.CARD, 2345.90),
                new OrderRow(7, "Mike", OrderStatus.CANCELLED, PaymentChoice.CASH, 1200.89),
                new OrderRow(8, "Alice", OrderStatus.PAID, PaymentChoice.CARD, 789.99),
                new OrderRow(9, "Anna", OrderStatus.CANCELLED, PaymentChoice.CRYPTO, 890.90),
                new OrderRow(10, "Mike", OrderStatus.PAID, PaymentChoice.CASH, 10000.00)
                );

        paidByCustomer(orders, "Mike").forEach(System.out::println);
        System.out.println(OrderAnalytics.revenue(orders));
        System.out.println(OrderAnalytics.countByStatus(orders));
        System.out.println(OrderAnalytics.revenueByPayment(orders));
        System.out.println(OrderAnalytics.page(orders, 2, 4));
    }

    //Только заказы этого клиента со статусом PAID
    static List<OrderRow> paidByCustomer(List<OrderRow> orders, String customer) {
        return orders.stream()
                .filter(n -> n.getCustomer().equals(customer) && n.getStatus().equals(OrderStatus.PAID))
                .toList();
    }

    //Сумма total по всем заказам, кроме CANCELLED
    static double revenue(List<OrderRow> orders) {
        return orders.stream()
                .filter(o -> !o.getStatus().equals(OrderStatus.CANCELLED))
                .mapToDouble(x -> x.getTotal())
                .sum();
    }

    //Количество заказов по статусам
    static Map<OrderStatus, Long> countByStatus(List<OrderRow> orders) {
        return orders.stream()
                .collect(Collectors.groupingBy(s -> s.getStatus(), Collectors.counting()));
    }

    //Выручка по способам оплаты
    static Map<PaymentChoice, Double> revenueByPayment(List<OrderRow> orders) {
        return orders.stream()
                .filter(o -> !o.getStatus().equals(OrderStatus.CANCELLED))
                .collect(Collectors.groupingBy(o -> o.getPayment(), Collectors.summingDouble(o -> o.getTotal())));
    }

    //Пагинация
    static Page<OrderRow> page(List<OrderRow> orders, int pageNum, int pageSize) {
        List<OrderRow> items = orders.stream()
                .skip((pageNum - 1) * pageSize)
                .limit(pageSize)
                .toList();
        return new Page<>(items, pageNum, pageSize,
                orders.size());
    }

}
