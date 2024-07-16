package main.java.assignment1.services;

import main.java.assignment1.models.Item;

public class ItemValuesDisplayService {

    private final TaxCalculatorService taxCalculatorService;
    private final Item item;
    public ItemValuesDisplayService(TaxCalculatorService taxCalculatorService,Item item){
        this.taxCalculatorService=taxCalculatorService;
        this.item=item;
    }
    public String showItemValues() {

        double tax = taxCalculatorService.calculateTax(item.getType(),item.getPrice());
        double finalPrice = item.getPrice() + tax;

        return  """
               Item:
               Name: %s
               Type: %s
               Price: %.2f
               Quantity: %d
               Tax: %.2f
               Final Price: %.2f
               """.formatted(item.getName(), item.getType(), item.getPrice(), item.getQuantity(), tax, finalPrice);
    }
}
