package com.barraiser.cleartrip.dtos;

import com.barraiser.cleartrip.models.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateRestaurantDTO {

    private String name;

    private double processingCapacity;

    private double latitude;

    private double longitude;

    private List<Item> itemList;
}
