package assignment1.utils;

import java.util.HashMap;
import java.util.Map;

public class ArgumentParser {
    public static Map<String, String> parseArguments(String[] args) {
        Map<String, String> arguments = new HashMap<>();
        for (int i = 0; i < args.length; i+=2) {
            if (args[i].startsWith("-") && i + 1 < args.length) {
                arguments.put(args[i], args[i + 1]);
            }
        }
        return arguments;
    }
}
