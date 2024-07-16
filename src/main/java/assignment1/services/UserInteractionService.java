package main.java.assignment1.services;

import main.java.assignment1.prompts.UserInteractionPrompt;

import java.util.Scanner;

public class UserInteractionService {
    private final static Scanner scanner = new Scanner(System.in);

    public String[] promptForUserInput(){
        System.out.println(UserInteractionPrompt.PROMPT_DETAILS);
        System.out.println(UserInteractionPrompt.PROMPT_ENTER_DETAILS);

        String input = scanner.nextLine();
        return input.split(" ");
    }

    public boolean promptForAnotherItemInput(){
        System.out.print(UserInteractionPrompt.PROMPT_ANY_OTHER_ITEM);
        String userResponse = scanner.next();
        scanner.nextLine();

        return userResponse.equalsIgnoreCase("y");

    }
}
