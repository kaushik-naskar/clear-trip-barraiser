package com.barraiser.cleartrip.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private long id; //1

    private String referenceId; //# REF_ID_1

    private Restaurant restaurant;

    private List<Item> items;

    private double totalPrice;

    private OrderStatus status;


}
