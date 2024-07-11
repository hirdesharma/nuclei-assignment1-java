import main.java.assignment1.validators.ItemValidator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import main.java.assignment1.exceptions.InvalidArgument;
import java.util.HashMap;
import java.util.Map;

class ItemValidatorTest {

    @Test
    public void testValidInput() {
        String[] args = {"-name", "tomato", "-type", "raw", "-price", "100", "-quantity", "10"};
        Map<String, String> inputArgs = new HashMap<>();
        inputArgs.put("-name", "tomato");
        inputArgs.put("-type", "raw");
        inputArgs.put("-price", "100.0");
        inputArgs.put("-quantity", "10");

        ItemValidator validator = new ItemValidator(args, inputArgs);
        assertDoesNotThrow(validator::validate);
    }
    @Test
    public void testMissingRequiredArguments() {
        String[] args = {"-name", "tomato", "-quantity", "10","-price","100"};
        Map<String, String> inputArgs = new HashMap<>();
        inputArgs.put("-name", "tomato");
        inputArgs.put("-type", "raw");

        ItemValidator validator = new ItemValidator(args, inputArgs);
        assertThrows(InvalidArgument.class, validator::validate);
    }
    @Test
    public void testInvalidItemType() {
        String[] args = {"-name", "tomato", "-type", "rew", "-price", "100.0", "-quantity", "10"};
        Map<String, String> inputArgs = new HashMap<>();
        inputArgs.put("-name", "tomato");
        inputArgs.put("-type", "invalid");
        inputArgs.put("-price", "100.0");
        inputArgs.put("-quantity", "10");

        ItemValidator validator = new ItemValidator(args, inputArgs);
        assertThrows(InvalidArgument.class, validator::validate);
    }
    @Test
    public void testAlphabeticalPriceAndQuantityValue() {
        String[] args = {"-name", "tomato", "-type", "raw", "-price", "54h", "-quantity", "1i0"};
        Map<String, String> inputArgs = new HashMap<>();
        inputArgs.put("-name", "tomato");
        inputArgs.put("-type", "raw");
        inputArgs.put("-price", "invalid");
        inputArgs.put("-quantity", "10");

        ItemValidator validator = new ItemValidator(args, inputArgs);
        assertThrows(InvalidArgument.class, validator::validate);
    }
}