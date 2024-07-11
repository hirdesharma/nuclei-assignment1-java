package main.java.assignment1.services;

import main.java.assignment1.models.Item;
import main.java.assignment1.utils.ArgumentParserUtils;
import main.java.assignment1.validators.ItemValidator;

import java.util.Map;
import java.util.Scanner;

public class ItemManager {

    //   asking user to enter details
    private static final String PROMPT_DETAILS = """

        Please provide item details in the format:
         -name <item name>
         -price <item price>
         -quantity <item quantity>
         -type <item type>""" ;
    private static final String PROMPT_ENTER_DETAILS = "\nEnter item details: ";
    private static final String PROMPT_ANY_OTHER_ITEM = "Do you want to enter details of any other item (y/n): ";

    public void startManager() {
        Scanner scanner = new Scanner(System.in);
        boolean addItem = true;

        while (addItem) {
            try {
                System.out.println(PROMPT_DETAILS);
                System.out.println(PROMPT_ENTER_DETAILS);

                String input = scanner.nextLine();
                String[] arguments = input.split(" ");

                ArgumentParserUtils parser = new ArgumentParserUtils();
                Map<String, String> inputArgs = parser.parseArguments(arguments);


                ItemValidator validateItem = new ItemValidator();
                validateItem.setArguments(arguments);
                validateItem.setInputArgs(inputArgs);
                validateItem.validate();

                createAndShowItem(inputArgs);

                System.out.print(PROMPT_ANY_OTHER_ITEM);
                String userResponse = scanner.next();
                scanner.nextLine();

                addItem = userResponse.equalsIgnoreCase("y");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private void createAndShowItem(Map<String, String> inputArgs) {
        String itemName = inputArgs.get("-name");
        double itemPrice = Double.parseDouble(inputArgs.get("-price"));
        int itemQuantity = Integer.parseInt(inputArgs.get("-quantity"));
        String itemType = inputArgs.get("-type");

        Item item = new Item(itemName, itemType, itemPrice, itemQuantity);
        System.out.println(item.showItemValues());
    }
}