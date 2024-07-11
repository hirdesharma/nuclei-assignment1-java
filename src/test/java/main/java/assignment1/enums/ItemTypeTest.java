package main.java.assignment1.enums;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ItemTypeTest {

    @Test
    public void testFromStringRaw() {
        assertEquals(ItemType.RAW, ItemType.fromString("raw"));
    }

    @Test
    public void testFromStringManufactured() {
        assertEquals(ItemType.MANUFACTURED, ItemType.fromString("manufactured"));
    }

    @Test
    public void testFromStringImported() {
        assertEquals(ItemType.IMPORTED, ItemType.fromString("imported"));
    }

    @Test
    public void testFromStringUpperCase() {
        assertEquals(ItemType.RAW, ItemType.fromString("RAW"));
        assertEquals(ItemType.MANUFACTURED, ItemType.fromString("MANUFACTURED"));
        assertEquals(ItemType.IMPORTED, ItemType.fromString("IMPORTED"));
    }

    @Test
    public void testFromStringMixedCase() {
        assertEquals(ItemType.RAW, ItemType.fromString("RaW"));
        assertEquals(ItemType.MANUFACTURED, ItemType.fromString("mAnUFaCtuReD"));
        assertEquals(ItemType.IMPORTED, ItemType.fromString("IMPorted"));
    }

    @Test
    public void testFromStringInvalidType() {
        assertThrows(IllegalArgumentException.class, () -> {
            ItemType.fromString("invalid");
        });
    }
}
