package es.daw.foodexpressapi.controller;

import es.daw.foodexpressapi.dto.OrderResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @GetMapping
    public List<OrderResponseDTO> filterOrders(
            @RequestParam String status,
            @RequestParam Long userId,
            @RequestParam Long restaurantId
    ) {


            return null;

    }
}
