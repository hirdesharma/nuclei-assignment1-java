package main.java.assignment1.services;

public class ItemValuesDisplayService implements ItemValuesDisplayServiceInterface{

  private final TaxCalculatorService taxCalculatorService;
  private final ItemInterface item;

  public ItemValuesDisplayService(TaxCalculatorService taxCalculatorService, ItemInterface item) {
    this.taxCalculatorService = taxCalculatorService;
    this.item = item;
  }

  @Override
  public String showItemValues() {

    double tax = taxCalculatorService.calculateTax(item.getType(), item.getPrice());
    double finalPrice = item.getPrice() + tax;

    return """
        Item:
        Name: %s
        Type: %s
        Price: %.2f
        Quantity: %d
        Tax: %.2f
        Final Price: %.2f
        """.formatted(item.getName(), item.getType(), item.getPrice(), item.getQuantity(), tax,
        finalPrice);
  }
}
