package com.base.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//ответ сервера
public class OrderResponse {
    private Integer id;
    private String status;
    //если при маппинге будет указано поле total вместо price, маппинг пройдет успешно. это как второе имя параметра
    //@JsonProperty("total")
    private Double price;
}
