package es.daw.foodexpressapi.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DishDTO {
    private String name;
    private BigDecimal price;
    private String category;
    private RestaurantDTO restaurant;
}

