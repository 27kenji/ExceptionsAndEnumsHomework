package com.oop_inheritans;

//пример наслдования
//класс должен реализовать абстрактные методы класса BasePage, если наследует этот класс
public class LoginPage extends BasePage {

     //конструктор, через который будет прокидываться baseUrl в родительский класс
    //если родительский класс содержит конструктор, то классы-наследники должны этот конструктор передать выше в класс-родитель (?)
    //super(...) — вызов конструктора родителя (обязателен первой строкой)
    protected LoginPage(String baseUrl) {
        super(baseUrl);
    }

    //имплементирование и переопредение абстрактных методов класса-родителя
    @Override
    public String url() {
        return baseUrl + "/login";
    }

    @Override
    public String readySelector() {
        return "#submitBtn";
    }

    public void enterCredentials(String email, String password) {
        System.out.println("[LOGIN]" + email + " /" + "*".repeat(password.length()));
    }
}
