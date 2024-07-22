package main.java.assignment1.services;

import java.util.Map;
import main.java.assignment1.exceptions.InvalidArgument;
import main.java.assignment1.utils.ArgumentParserUtilsInterface;
import main.java.assignment1.validators.ItemValidator;

public class ItemManagerService implements ItemManagerServiceInterface {
  private final ArgumentParserUtilsInterface argumentParser;
  private final ItemValidator itemValidator;
  private final UserInteractionService userInteractionService;
  private final CreateAndShowItemServiceInterface createAndShowItemService;

  public ItemManagerService(ArgumentParserUtilsInterface argumentParser,
                            ItemValidator itemValidator,
                            UserInteractionService userInteractionService,
                            CreateAndShowItemServiceInterface createAndShowItemService) {
    this.argumentParser = argumentParser;
    this.itemValidator = itemValidator;
    this.userInteractionService = userInteractionService;
    this.createAndShowItemService = createAndShowItemService;
  }

  @Override
  public void startManager() {
    boolean addItem = true;

    while (addItem) {
      try {
        String[] arguments = userInteractionService.promptForUserInput();

        Map<String, String> inputArgs = argumentParser.parseArguments(arguments);
        itemValidator.setInputArgs(inputArgs);
        itemValidator.setArguments(arguments);
        itemValidator.validate();
        createAndShowItemService.createAndShowItem(inputArgs);

        addItem = userInteractionService.promptForAnotherItemInput();
      } catch (Exception e) {
        throw new InvalidArgument("Error : " + e.getMessage());
      }
    }
  }
}