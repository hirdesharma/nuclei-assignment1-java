package main.java.assignment1.models;

import main.java.assignment1.enums.ItemType;
import main.java.assignment1.services.TaxCalculatorService;

public class Item {
    private final String name;
    private final ItemType type;
    private final double price;
    private final int quantity;

    public Item(String name, String type, double price, int quantity) {
        this.name = name;
        this.type = ItemType.fromString(type);
        this.price = price;
        this.quantity = quantity;
    }

    public String showItemValues() {
        TaxCalculatorService taxCalculatorService = new TaxCalculatorService();
        double tax = taxCalculatorService.calculateTax(type,price);
        double finalPrice = price + tax;

        return """
               Item:
               Name: %s
               Type: %s
               Price: %.2f
               Quantity: %d
               Tax: %.2f
               Final Price: %.2f
               """.formatted(name, type, price, quantity, tax, finalPrice);
    }
}