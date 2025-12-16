package com.devtalles.labs.functional_programing.record;

import java.util.Objects;

public final class Product {
    private final String name;
    private final String description;
    private final double price;

    public Product(String name, String description, double price) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product person = (Product) o;
        return Double.compare(price, person.price) == 0 && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
