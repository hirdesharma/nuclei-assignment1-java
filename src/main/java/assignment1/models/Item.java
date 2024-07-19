package main.java.assignment1.models;

import main.java.assignment1.enums.ItemType;

public class Item implements ItemInterface {
  private String name;
  private ItemType type;
  private double price;
  private int quantity;

  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public void setType(String type) {
    this.type = ItemType.fromString(type);
  }

  @Override
  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public ItemType getType() {
    return type;
  }

  @Override
  public double getPrice() {
    return price;
  }

  @Override
  public int getQuantity() {
    return quantity;
  }

}