package main.java.assignment1.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class ItemTest {

    @Test
    public void testShowItemValues() {
        Item item = new Item("Laptop", "RAW", 1000, 2);
        String expectedOutput = """
               Item:
               Name: %s
               Type: %s
               Price: %.2f
               Quantity: %d
               Tax: %.2f
               Final Price: %.2f
               """.formatted("Laptop", "RAW",1000.00,2,125.00, 1125.0); // Assuming TaxCalculator calculates a tax of 100 for simplicity

        String actualOutput = item.showItemValues();
        assertEquals(expectedOutput,actualOutput);
    }
}