package com.barraiser.cleartrip.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    private long id;

    private String name;

    private double price;

    private double processingTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return getName().equalsIgnoreCase(item.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
