package com.barraiser.cleartrip.commands;

import com.barraiser.cleartrip.common.ItemUtils;
import com.barraiser.cleartrip.controllers.RestaurantController;
import com.barraiser.cleartrip.dtos.UpdateItemsDTO;
import com.barraiser.cleartrip.models.Item;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UpdateItems implements Command{

    private static final String UPDATE_ITEMS = "update_items";

    private final RestaurantController controller;

    public UpdateItems(RestaurantController controller) {
        this.controller = controller;
    }

    @Override
    public boolean matches(String cmd) {
        return cmd.startsWith(UPDATE_ITEMS);
    }

    //update_items(id: 1, items: [name: Rice, price: 150, processingTime: 25; name: Palak, price: 200, processingTime: 10])
    @Override
    public void execute(String cmd) {
        cmd = cmd.replace("add_items(","");
        cmd = cmd.substring(0,cmd.length()-1);
        String id = cmd.substring(cmd.indexOf(":")+1,cmd.indexOf(",")).trim();
        cmd = cmd.substring(cmd.indexOf(",")+1).trim();
        System.out.println(id);
        System.out.println(cmd);
        List<Item> items = new ArrayList<>();
        ItemUtils.parseItems(cmd,items);
        UpdateItemsDTO respo = controller.updateItems(Long.parseLong(id),items);
        System.out.println(respo);
    }
}
