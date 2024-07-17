    package main.java.assignment1.services;
    import main.java.assignment1.exceptions.InvalidArgument;
    import main.java.assignment1.utils.ArgumentParserUtils;
    import main.java.assignment1.validators.ItemValidator;

    import java.util.Map;

    public class ItemManagerService {
        private final ArgumentParserUtils argumentParser;
        private final ItemValidator itemValidator;
        private final UserInteractionService userInteractionService;
        private final CreateAndShowItemService createAndShowItemService;

        public ItemManagerService(ArgumentParserUtils argumentParser,
                                  ItemValidator itemValidator,
                                  UserInteractionService userInteractionService,
                                  CreateAndShowItemService createAndShowItemService) {
            this.argumentParser = argumentParser;
            this.itemValidator = itemValidator;
            this.userInteractionService = userInteractionService;
            this.createAndShowItemService = createAndShowItemService;
        }

        public void startManager() {
            boolean addItem = true;

            while (addItem) {
                try {
                    String[] arguments = userInteractionService.promptForUserInput();

                    Map<String, String> inputArgs =  argumentParser.parseArguments(arguments);
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