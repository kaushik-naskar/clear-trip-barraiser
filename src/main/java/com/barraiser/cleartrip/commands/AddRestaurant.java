package com.barraiser.cleartrip.commands;

import com.barraiser.cleartrip.common.ItemUtils;
import com.barraiser.cleartrip.controllers.RestaurantController;
import com.barraiser.cleartrip.dtos.CreateRestaurantDTO;
import com.barraiser.cleartrip.dtos.CreateRestaurantResponse;
import com.barraiser.cleartrip.models.Item;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddRestaurant implements Command{

    private static final String CMD = "add_restaurant";

    private final RestaurantController controller;

    public AddRestaurant(RestaurantController controller) {
        this.controller = controller;
    }

    @Override
    public boolean matches(String cmd) {

        return cmd.startsWith(CMD);
    }

//"add_restaurant(name: Rest, processingCapacity: 100, latitude: -74, longitude: 74, items: [name: Rice, price: 100, processingTime: 25; name: Dal, price: 200, processingTime: 10])

//    "add_restaurant(name: string, processingCapacity: double, latitude: double, longitude: double, " +
//            "items: [name: string, price: double, processingTime: double; name: string, price: double, processingTime: double; ...])
    @Override
    public void execute(String cmd) {
        cmd = cmd.replace("add_restaurant(","");
        cmd = cmd.substring(0,cmd.length()-1);
        String name = cmd.substring(cmd.indexOf(":")+1,cmd.indexOf(",")).trim();
        cmd = cmd.substring(cmd.indexOf(",")+1).trim();
        double processingCapacity = Double.parseDouble(cmd.substring(cmd.indexOf(":")+1,cmd.indexOf(",")).trim());
        cmd = cmd.substring(cmd.indexOf(",")+1).trim();
        double latitude = Double.parseDouble(cmd.substring(cmd.indexOf(":")+1,cmd.indexOf(",")).trim());
        cmd = cmd.substring(cmd.indexOf(",")+1).trim();
        double longitude = Double.parseDouble(cmd.substring(cmd.indexOf(":")+1,cmd.indexOf(",")).trim());
        cmd = cmd.substring(cmd.indexOf(",")+1).trim();
        System.out.println(name+" "+processingCapacity+" "+latitude+" "+longitude);
        System.out.println(cmd);
        List<Item> items = new ArrayList<>();
        ItemUtils.parseItems(cmd,items);
        CreateRestaurantDTO createRestaurantDTO = new CreateRestaurantDTO(name,processingCapacity,latitude,longitude,items);
        CreateRestaurantResponse response = controller.createRestaurant(createRestaurantDTO);
        System.out.println(response.getMessage());
    }


}
