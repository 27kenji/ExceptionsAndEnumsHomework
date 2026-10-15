package com.files_properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

public class Theory {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();

        //код в () сам закроет чтение из файла
        try (InputStream resourceAsStream = Theory.class.getClassLoader().getResourceAsStream("app.properties")) {
            properties.load(resourceAsStream);
        }

        //получение из файла значений переменных и преобразование
        String url = properties.getProperty("url");
        int threadCount = Integer.parseInt(properties.getProperty("threadCount"));
        boolean isRemote = Boolean.parseBoolean(properties.getProperty("isRemote"));

        //переменные окружения ПК
        Map<String, String> getenv = System.getenv();
    }
}
