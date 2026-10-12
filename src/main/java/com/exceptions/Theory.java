package com.exceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Theory {
    public static void main(String[] args) {
        //это пример обработки кастомной ошибки
        //вызываем кастомный статичный метод без создания объекта класса
        findOrderStatus(50);

        //это пример обработки обрабатываемой (компилятором) ошибки; метод readContentFromFile опасный, потому что чтение из файла может быть прервано извне
        //опасный блок кода поместили в блок try
        try {
            String content = readContentFromFile("rc/main/resources/file.txt");
            System.out.println(content);
            //e - это переменная, которая хранит ссылку на объект исключения (обычно пойманное ранее)
        } catch (IOException e) {
            //строка ниже аварийно завершает программу, но блок catch можно оставить пустым
            throw new RuntimeException(e);
            //или чтобы не останавливать программу, в блоке catch можно просто вывести стектрейс:
            //e.printStackTrace();

            //блок finally выполнится в любом случае; используют например для очистки ресурсов
        } finally {
            System.out.println("Код внутри finally");
        }

    }

    //метод, который возвращает кастомную ошибку, используя конструкцию throw; бросает исключение вручную,
    // т.е. самостоятельно задпаются условия, при выполнении которых вернется конкретный exception
    //throw - это выкидывание СВОЕЙ ошибки для авварийного завершения программы, говорит что прямо СЕЙЧАС выкинется ошибка;
    //в автотестировании обычно не используют, только try-catch(Exception e)
    public static String findOrderStatus(int orderId) {
        if (orderId <= 0) {
            throw new IllegalArgumentException("orderId must be positive");
        }

        if (orderId == 1000) {
            throw new OrderNotFoundException(orderId);
        }

        return "PAID";
    }

    //throws - если где-то будет вызываться метод readContentFromFile, то возможна ошибка IOException
    //это обрабатываемая ошибка, отсутствие обработки которой не пропустит компилятор
    //компилятор сам предложит добавить throws в сигнатуре метода при создании опасного метода
    public static String readContentFromFile(String path) throws IOException {
        //чтение файла из ресурсов проекта
        return Files.readString(Path.of(path));

    }
}
