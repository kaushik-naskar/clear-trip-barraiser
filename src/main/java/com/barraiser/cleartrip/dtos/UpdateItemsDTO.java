package com.barraiser.cleartrip.dtos;

import com.barraiser.cleartrip.models.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateItemsDTO {

    private long restaurantId;

    private List<Item> items;
}
