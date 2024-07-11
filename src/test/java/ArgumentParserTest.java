import main.java.assignment1.exceptions.InvalidArgument;
import main.java.assignment1.utils.ArgumentParser;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


class ArgumentParserTest {

    @Test
    public void testValidValues() {
        String[]args = {"-name","tomato","-type","raw","-price","100","-quantity","10"};
        Map<String, String> result = ArgumentParser.parseArguments(args);
        assertEquals(4, result.size());
        assertEquals("tomato", result.get("-name"));
        assertEquals("raw", result.get("-type"));
        assertEquals("100", result.get("-price"));
        assertEquals("10", result.get("-quantity"));
    }
    @Test
    public void testMissingValue() {
        String[] args = {"-name"};
        assertThrows(InvalidArgument.class, () -> {
            ArgumentParser.parseArguments(args);
        });
    }
    @Test
    public void testMixedValidAndInvalidArguments() {
        String[] args = {"-name","tomato","type","raw","-price","100","-quantity","10"};
        assertThrows(InvalidArgument.class, () -> {
            ArgumentParser.parseArguments(args);
        });
    }
    @Test
    public void testEmptyArguments() {
        String[] args = {};
        Map<String, String> result = ArgumentParser.parseArguments(args);
        assertTrue(result.isEmpty());
    }
}