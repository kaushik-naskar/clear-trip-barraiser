package com.barraiser.cleartrip.common;

import com.barraiser.cleartrip.models.Item;

import java.util.List;

public class ItemUtils {

    public static void parseItems(String cmd, List<Item> items) {
        cmd = cmd.replace("items:","");
        cmd = cmd.substring(1,cmd.length()-1);
        String[] itemStrings = cmd.split(";");
        for (String itemString : itemStrings) {
            Item item =  new Item();
            item.setName(itemString.substring(itemString.indexOf(":")+1,itemString.indexOf(",")).trim());
            itemString = itemString.substring(itemString.indexOf(",")+1).trim();
            item.setPrice(Double.valueOf(itemString.substring(itemString.indexOf(":")+1,itemString.indexOf(",")).trim()));
            cmd = cmd.substring(itemString.indexOf(",")+1).trim();
            item.setProcessingTime(Double.valueOf(itemString.substring(itemString.indexOf(":")+1,itemString.indexOf(",")).trim()));

        }
    }
}
