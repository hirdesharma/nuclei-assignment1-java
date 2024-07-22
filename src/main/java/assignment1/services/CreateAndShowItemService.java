package main.java.assignment1.services;

import main.java.assignment1.models.Item;

import java.util.Map;

public class CreateAndShowItemService implements CreateAndShowItemServiceInterface{
    @Override
    public void createAndShowItem(Map<String, String> inputArgs) {
        String itemName = inputArgs.get("-name");
        double itemPrice = Double.parseDouble(inputArgs.get("-price"));
        int itemQuantity = Integer.parseInt(inputArgs.get("-quantity"));
        String itemType = inputArgs.get("-type");

        ItemInterface item = new Item();
        item.setName(itemName);
        item.setPrice(itemPrice);
        item.setType(itemType);
        item.setQuantity(itemQuantity);

        TaxCalculatorService taxCalculatorService = new TaxCalculatorService();
        ItemValuesDisplayService itemValuesDisplayService = new ItemValuesDisplayService(taxCalculatorService,item);
        System.out.println(itemValuesDisplayService.showItemValues());
    }
}
