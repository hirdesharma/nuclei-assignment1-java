package main.java.assignment1.models;

import main.java.assignment1.enums.ItemType;

public interface ItemInterface {
  void setName(String name);

  void setType(String type);

  void setPrice(double price);

  void setQuantity(int quantity);

  double getPrice();

  int getQuantity();

  String getName();

  ItemType getType();
}
