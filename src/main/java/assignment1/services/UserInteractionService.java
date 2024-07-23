package main.java.assignment1.services;

import java.util.Scanner;
import main.java.assignment1.prompts.UserInteractionPrompt;

public class UserInteractionService implements UserInteractionServiceInterface {
  private final static Scanner scanner = new Scanner(System.in);

  @Override
  public String[] promptForUserInput() {
    System.out.println(UserInteractionPrompt.PROMPT_DETAILS);
    System.out.println(UserInteractionPrompt.PROMPT_ENTER_DETAILS);

    String input = scanner.nextLine();
    return input.split(" ");
  }

  @Override
  public boolean promptForAnotherItemInput() {
    System.out.print(UserInteractionPrompt.PROMPT_ANY_OTHER_ITEM);
    String userResponse = scanner.next();
    scanner.nextLine();

    return userResponse.equalsIgnoreCase("y");

  }
}
