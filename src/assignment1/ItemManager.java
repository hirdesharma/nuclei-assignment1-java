package assignment1;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class ItemManager {
    public void startManager(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean addItem = true;

        while (addItem) {
            try {
                System.out.println("\nPlease provide item details in the format:");
                System.out.println("\n -name <item name> \n -price <item price> \n -quantity <item quantity> \n -type <item type>");

                System.out.println("\nEnter item details: ");

                String input = scanner.nextLine();
                String[] arguments = input.split(" ");
                Map<String, String> inputArgs = parseArguments(arguments);

                
                ItemValidator validateItem = new ItemValidator(arguments,inputArgs);
                validateItem.validate();

                String itemName = inputArgs.get("-name");
                double itemPrice = Double.parseDouble(inputArgs.get("-price"));
                int itemQuantity = Integer.parseInt(inputArgs.get("-quantity"));
                String itemType = inputArgs.get("-type");

                Item item = new Item(itemName, itemType, itemPrice, itemQuantity);
                System.out.println(item.showItemValues());

                System.out.print("Do you want to enter details of any other item (y/n): ");
                String userResponse = scanner.next();
                scanner.nextLine();

                addItem = userResponse.equalsIgnoreCase("y");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private static Map<String, String> parseArguments(String[] args) {
        Map<String, String> arguments = new HashMap<>();
        for (int i = 0; i < args.length; i+=2) {
            if (args[i].startsWith("-") && i + 1 < args.length) {
                arguments.put(args[i], args[i + 1]);
            }
        }
        return arguments;
    }
}