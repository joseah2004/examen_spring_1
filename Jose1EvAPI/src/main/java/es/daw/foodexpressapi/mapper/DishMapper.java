package es.daw.foodexpressapi.mapper;

import es.daw.foodexpressapi.dto.DishDTO;
import es.daw.foodexpressapi.entity.Dish;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DishMapper {

    private final RestaurantMapper restaurantMapper;

    public DishDTO toDTO(Dish dish) {
        if (dish == null) return null;

        return new DishDTO(
                dish.getName(),
                dish.getPrice(),
                dish.getCategory(),
                dish.getRestaurant() != null
                        ? restaurantMapper.toDTO(dish.getRestaurant())
                        : null
        );
    }
}

