package com.barraiser.cleartrip.services;

import com.barraiser.cleartrip.models.Item;
import com.barraiser.cleartrip.models.Menu;
import com.barraiser.cleartrip.models.Restaurant;
import com.barraiser.cleartrip.repositories.RestaurantRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant createRestaurant(String name, double processingCapacity, double latitude, double longitude, List<Item> itemList) {
        Menu menu = new Menu(itemList);
        Restaurant newRestaurant = new Restaurant(name, processingCapacity, latitude, longitude, menu);
        if(restaurantRepository.ifExists(newRestaurant)){
            //throw exception
        }
        newRestaurant = restaurantRepository.addRestaurant(newRestaurant);
        return newRestaurant;

    }

    public Restaurant updateItems(long restaurantId, List<Item> items) {
        Restaurant restaurant = restaurantRepository.getById(restaurantId);
        Map<String, Item> nameToItemMap =items.stream().collect(Collectors.toMap(Item::getName, item -> item));
        if(Objects.nonNull(restaurant) && Objects.nonNull(restaurant.getMenu())){
            if(CollectionUtils.isEmpty(restaurant.getMenu().getItem())){
                restaurant.getMenu().setItem(items);
            } else {
                for (Item item:restaurant.getMenu().getItem()) {
                    if(nameToItemMap.keySet().add(item.getName())){
                        item.setPrice(nameToItemMap.get(item.getName()).getPrice());
                        item.setProcessingTime(nameToItemMap.get(item.getName()).getProcessingTime());
                        nameToItemMap.remove(item.getName());
                    }
                }
                restaurant.getMenu().getItem().addAll(nameToItemMap.values());
            }
        }
        else{
            //throw exception
        }
        return restaurant;
    }
}
