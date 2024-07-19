package main.java.assignment1.validators;

import java.util.Map;

public interface ItemValidatorInterface {
  void setArguments(String[] arguments);
  void setInputArgs(Map<String, String> inputArgs);
  void validate();
}
