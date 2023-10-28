package com.barraiser.cleartrip.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
public class Restaurant {

    private Long id;

    private String name;

    private double processingCapacity;

    private double latitude;

    private double longitude;

    private Menu menu;

    public Restaurant(String name, double processingCapacity, double latitude, double longitude, Menu menu) {
        this.name = name;
        this.processingCapacity = processingCapacity;
        this.latitude = latitude;
        this.longitude = longitude;
        this.menu = menu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Restaurant)) return false;
        Restaurant that = (Restaurant) o;
        return Double.compare(that.getProcessingCapacity(), getProcessingCapacity()) == 0 && Double.compare(that.getLatitude(), getLatitude()) == 0 && Double.compare(that.getLongitude(), getLongitude()) == 0 && this.name.equalsIgnoreCase(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getProcessingCapacity(), getLatitude(), getLongitude());
    }
}
