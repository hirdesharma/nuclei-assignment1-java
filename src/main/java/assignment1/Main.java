package main.java.assignment1;

import main.java.assignment1.services.CreateAndShowItemService;
import main.java.assignment1.services.CreateAndShowItemServiceInterface;
import main.java.assignment1.services.ItemManagerService;
import main.java.assignment1.services.UserInteractionService;
import main.java.assignment1.utils.ArgumentParserUtils;
import main.java.assignment1.utils.ArgumentParserUtilsInterface;
import main.java.assignment1.validators.ItemValidator;
import main.java.assignment1.validators.ItemValidatorInterface;

public class Main {
    public static void main(String[] args) {
        ArgumentParserUtilsInterface argumentParser = new ArgumentParserUtils();
        ItemValidatorInterface itemValidator = new ItemValidator();
        UserInteractionService userInteractionService = new UserInteractionService();
        CreateAndShowItemServiceInterface createAndShowItemService = new CreateAndShowItemService();

        ItemManagerService manager = new ItemManagerService(argumentParser,itemValidator,userInteractionService,createAndShowItemService);

        manager.startManager();
    }
}
