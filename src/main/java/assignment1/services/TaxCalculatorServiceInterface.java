package main.java.assignment1.services;

import main.java.assignment1.enums.ItemType;

public interface TaxCalculatorServiceInterface {
  double calculateTax(ItemType type, Double price);
}
