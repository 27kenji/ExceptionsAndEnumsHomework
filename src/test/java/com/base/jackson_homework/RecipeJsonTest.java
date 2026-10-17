package com.base.jackson_homework;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

class RecipeJsonTest {
    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void serializeViaBuilder() throws JsonProcessingException {
        Recipe recipe = Recipe.builder()
                .id(1)
                .name("Margarita")
                .price(299.0)
                .build();
        String json = mapper.writeValueAsString(recipe);

        assertSoftly(x -> {
            x.assertThat(json).contains("\"id\":1");
            x.assertThat(json).contains("\"name\":\"Margarita\"");
            x.assertThat(json).contains("\"price\":299.0");
                }
                );
    }

    @Test
    public void deserializeOneRecipe() throws JsonProcessingException {
        String json = """
                { "id": 1, "name": "Margarita", "price": 299.0 }
                """;
        Recipe recipe = mapper.readValue(json, Recipe.class);

        assertSoftly(x -> {
            x.assertThat(recipe.getId()).isEqualTo(1);
            x.assertThat(recipe.getName()).isEqualTo("Margarita");
            x.assertThat(recipe.getPrice()).isEqualTo(299.0);
        });
    }

    @Test
    public void deserializeListViaTypeReference() throws JsonProcessingException {
        String json = """
  [
  { "id": 1, "name": "Margarita",   "price": 299.0 },
  { "id": 2, "name": "Pepperoni",   "price": 349.0 },
  { "id": 3, "name": "Four Cheese", "price": 399.0 }
  ]
  """;
        List<Recipe> recipes = mapper.readValue(json, new TypeReference<List<Recipe>>() {});
        assertThat(recipes).hasSize(3);
        assertThat(recipes)
                .extracting(Recipe::getName)
                .containsExactly("Margarita", "Pepperoni",
                        "Four Cheese");
    }
}
