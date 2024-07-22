package main.java.assignment1.validators;
import main.java.assignment1.exceptions.InvalidArgument;

import java.util.Map;
import java.util.Arrays;

public class ItemValidator{

    private String[] arguments;
    private Map<String, String> inputArgs;

    public void setArguments(String[] arguments){
        this.arguments = arguments;
    }
    public void setInputArgs(Map<String, String> inputArgs){
        this.inputArgs = inputArgs;
    }
    public void validate() {
        validateNumberOfArguments(inputArgs);
        validateTypeOfItem(inputArgs.get("-type"));
        validateCompulsoryArguments(arguments, inputArgs);
        validatePriceHasValidValue(inputArgs);
        validateQuantityHasValidValue(inputArgs);
    }

    private void validatePriceHasValidValue(Map<String, String> inputArgs) {
        try {
            if (inputArgs.containsKey("-price"))
                Double.parseDouble(inputArgs.get("-price"));
        } catch (NumberFormatException e) {
            throw new InvalidArgument("Invalid value : Item Price is not an Integer/Double");
        }
    }
    private void validateQuantityHasValidValue(Map<String, String> inputArgs) {
        try {
            if (inputArgs.containsKey("-quantity"))
                Integer.parseInt(inputArgs.get("-quantity"));
        } catch (NumberFormatException e) {
            throw new InvalidArgument("Invalid value : Item Quantity is not an Integer");
        }

    }
    private void validateTypeOfItem(String itemType) {
        String[] validTypeOfItem = { "raw", "manufactured", "imported" };
        if (!Arrays.asList(validTypeOfItem).contains(itemType.toLowerCase()))
            throw new InvalidArgument("Invalid Item Type , it should be either raw, manufactured or imported");
    }

    private void validateCompulsoryArguments(String[] arguments, Map<String, String> inputArgs) {
        if (!arguments[0].equalsIgnoreCase("-name"))
            throw new InvalidArgument("-name option must be the first option !");
        if (!inputArgs.containsKey("-type"))
            throw new InvalidArgument("-type option is compulsory !");
    }

    private void validateNumberOfArguments(Map<String, String> inputArgs) {
        if (inputArgs.size() < 4)
            throw new InvalidArgument("At least 4 commandline arguments needed and -name and -type options are must.");
    }
}
