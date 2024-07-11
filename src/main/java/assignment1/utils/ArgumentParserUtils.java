package main.java.assignment1.utils;

import main.java.assignment1.exceptions.InvalidArgument;

import java.util.HashMap;
import java.util.Map;

public class ArgumentParserUtils {
    public static Map<String, String> parseArguments(String[] args) {
        Map<String, String> arguments = new HashMap<>();
        for (int i = 0; i < args.length; i+=2) {
            if (args[i].startsWith("-") && i + 1 < args.length) {
                arguments.put(args[i], args[i + 1]);
            }else if(i + 1 < args.length){
                throw new InvalidArgument(args[i] + " must start with - and should be an valid input");
            }else{
                throw new InvalidArgument(args[i] + " must have a value");
            }
        }
        return arguments;
    }
}
