package com.base.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static org.assertj.core.api.Assertions.assertThat;

public class JacksonTest {

    private final ObjectMapper objectMapper = new ObjectMapper();
    @Test
    //скрываем exception JsonProcessingException
    @SneakyThrows
    public void test1() {
        //десереализация
        //в библиотеке Jackson есть только один основной класс objectMapper, нужно создавать один раз на все приложение и переиспользовать. Позволяет представить любой
        // java-объект в виде json и конвертировать любой json в java-объект

        //делаем сырой json, который будет дублировать структуру полей класса OrderResponse
        //""" - поддержка переноса строк
        String json = """
                {"id": 42, "status": "PAID", "price": 49.90}
                """;

        //превращаем json в объект, указываем тип данных класса, в который нужно преобразовать ответ
        OrderResponse orderResponse = objectMapper.readValue(json, OrderResponse.class);
        orderResponse.getStatus();
    }

    @Test
    @SneakyThrows
    //маппинг массивов с объектами, преобразование в типизированный список List<OrderResponse>
    public void test2() {
        String json = """
                [
                    {"id": 1, "status": "PAID", "price": 49.90},
                    {"id": 2, "status": "CREATED", "price": 55.50}
                ]
                """;
        List<OrderResponse> orderResponses = objectMapper.readValue(json, new TypeReference<List<OrderResponse>>() {
        });
        assertThat(orderResponses).hasSize(2);
    }

    //сериализация, собираем тело запроса и преобразовываем в json
    //поля класса OrderRequest будем превращать в json
    @Test
    @SneakyThrows
    public void test3() {
        //через builder создаем объект класса
        OrderRequest build = OrderRequest.builder()
                .quantity(1)
                .recipeId(10)
                .build();
        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(build);
        System.out.println(json);
    }

    /*примеры аннотаций:
    @JsonProperty("...") — связать поле с другим именем в JSON.
    @JsonIgnore — исключить поле из сериализации/десериализации.
    @JsonInclude(NON_NULL) — не писать в JSON поля со значением null.
    */

}
