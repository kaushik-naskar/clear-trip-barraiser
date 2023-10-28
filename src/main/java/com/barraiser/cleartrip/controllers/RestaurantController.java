package com.barraiser.cleartrip.controllers;

import com.barraiser.cleartrip.dtos.CreateRestaurantDTO;
import com.barraiser.cleartrip.dtos.CreateRestaurantResponse;
import com.barraiser.cleartrip.dtos.UpdateItemsDTO;
import com.barraiser.cleartrip.models.Item;
import com.barraiser.cleartrip.models.Restaurant;
import com.barraiser.cleartrip.services.RestaurantService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    public CreateRestaurantResponse createRestaurant(CreateRestaurantDTO restaurantDTO) {
        Restaurant restaurant = restaurantService.createRestaurant(restaurantDTO.getName(), restaurantDTO.getProcessingCapacity(), restaurantDTO.getLatitude(), restaurantDTO.getLongitude(), restaurantDTO.getItemList());
        return new CreateRestaurantResponse(restaurant.getId(), "Restaurant created successfully"  );
    }

    public UpdateItemsDTO updateItems(long restaurantId, List<Item> items) {
        Restaurant restaurant = restaurantService.updateItems(restaurantId, items);
        return new UpdateItemsDTO(restaurant.getId(), restaurant.getMenu().getItem());
    }
}
