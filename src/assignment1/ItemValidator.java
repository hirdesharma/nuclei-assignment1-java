package assignment1;
import assignment1.Exceptions.InvalidArgument;
import java.util.Map;
import java.util.Arrays;

public class ItemValidator {

    private String[] arguments;
    private Map<String, String> inputArgs;

    public ItemValidator(String[] arguments, Map<String, String> inputArgs) {
        this.arguments = arguments;
        this.inputArgs = inputArgs;
    }

    private void validateTypeOfItem(String itemType) {
        String[] validTypeOfItem = { "raw", "manufactured", "imported" };
        if (!Arrays.asList(validTypeOfItem).contains(itemType.toLowerCase()))
            throw new InvalidArgument("Invalid Item Type , it should be eitherraw, manufactured or imported");
    }

    private void validateEachOptionHasValidValue(Map<String, String> inputArgs) {
        validateTypeOfItem(inputArgs.get("-type"));

        try {
            if (inputArgs.containsKey("-price"))
                Double.parseDouble(inputArgs.get("-price"));
        } catch (NumberFormatException e) {
            throw new InvalidArgument("Invalid value : Item Price is not an Integer/Double");
        }
        try {
            if (inputArgs.containsKey("-quantity"))
                Integer.parseInt(inputArgs.get("-quantity"));
        } catch (NumberFormatException e) {
            throw new InvalidArgument("Invalid value : Item Quantity is not an Integer");
        }

    }

    private void validateCompulsoryArguments(String[] arguments, Map<String, String> inputArgs) {
        if (!arguments[0].equalsIgnoreCase("-name"))
            throw new InvalidArgument("-name option must be the first option !");
        if (!inputArgs.containsKey("-price"))
            throw new InvalidArgument("-type option is compulsory !");
    }

    private void validateNumberOfArguments(Map<String, String> inputArgs) {
        if (inputArgs.size() < 4)
            throw new InvalidArgument("At least 4 commandline arguments needed and -name and -type options are must.");
    }

    public void validate() {
        validateNumberOfArguments(inputArgs);
        validateCompulsoryArguments(arguments, inputArgs);
        validateEachOptionHasValidValue(inputArgs);
    }
}
