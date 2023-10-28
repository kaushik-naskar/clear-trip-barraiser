package com.barraiser.cleartrip.repositories;

import com.barraiser.cleartrip.models.Restaurant;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RestaurantRepository {

    private List<Restaurant> restaurants = new ArrayList<>();

    public boolean ifExists(Restaurant newRestaurant) {
        return restaurants.stream().anyMatch(restaurant -> restaurant.equals(newRestaurant));
    }


    public Restaurant addRestaurant(Restaurant newRestaurant) {
        newRestaurant.setId(restaurants.size() + 1L);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public boolean ifExists(long restaurantId) {
        return restaurants.stream().anyMatch(restaurant -> restaurant.getId() == restaurantId);
    }

    public Restaurant getById(long restaurantId) {
        if(restaurantId-1>=0 && restaurantId-1<restaurants.size())
            return restaurants.get((int) restaurantId-1);
        else
            return null;
    }
}
