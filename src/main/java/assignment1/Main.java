package main.java.assignment1;

import main.java.assignment1.services.CreateAndShowItemService;
import main.java.assignment1.services.ItemManagerService;
import main.java.assignment1.services.UserInteractionService;
import main.java.assignment1.utils.ArgumentParserUtils;
import main.java.assignment1.validators.ItemValidator;

public class Main {
    public static void main(String[] args) {
        ArgumentParserUtils argumentParser = new ArgumentParserUtils();
        ItemValidator itemValidator = new ItemValidator();
        UserInteractionService userInteractionService = new UserInteractionService();
        CreateAndShowItemService createAndShowItemService = new CreateAndShowItemService();

        ItemManagerService manager = new ItemManagerService(argumentParser,itemValidator,userInteractionService,createAndShowItemService);

        manager.startManager();
    }
}
