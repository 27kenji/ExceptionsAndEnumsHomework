package com.lambdas_streams;

public class Order {
    private final Long id;
    private final String status;
    private final Double total;
    private final String customer;

    public Order(Long id, String status, Double total, String customer) {
        this.id = id;
        this.status = status;
        this.total = total;
        this.customer = customer;
    }

    //использование полиморфизма - нужно переопределить метод toString, чтобы вместо хеш-кода при запросе возвращались значения параметров, т.к. стандартный метод equals
    //будет всегда возвращать false, т.к. ссылки у ссылочных объектов всегда разные. При переопределении метода будут сравниваться значения вместо хеш-кодов
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", total=" + total +
                ", customer='" + customer + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public Double getTotal() {
        return total;
    }

    public String getCustomer() {
        return customer;
    }
}
