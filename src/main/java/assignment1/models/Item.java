package main.java.assignment1.models;

import main.java.assignment1.enums.ItemType;

public class Item {
    private String name;
    private ItemType type;
    private double price;
    private int quantity;

    public void setName(String name) {
        this.name = name;
    }
    public void setType(String type) {
        this.type = ItemType.fromString(type);
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }
    public ItemType getType() {
        return type;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }

}