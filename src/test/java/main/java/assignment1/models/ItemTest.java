package main.java.assignment1.models;

import main.java.assignment1.enums.ItemType;
import main.java.assignment1.models.Item;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemTest {

    @Test
    public void testSetName() {
        Item item = new Item();
        item.setName("TestItem");
        assertEquals("TestItem", item.getName());
    }

    @Test
    public void testSetType() {
        Item item = new Item();
        item.setType("RAW");
        assertEquals(ItemType.RAW, item.getType());
    }

    @Test
    public void testSetPrice() {
        Item item = new Item();
        item.setPrice(100.0);
        assertEquals(100.0, item.getPrice());
    }

    @Test
    public void testSetQuantity() {
        Item item = new Item();
        item.setQuantity(2);
        assertEquals(2, item.getQuantity());
    }

    @Test
    public void testFullItem() {
        Item item = new Item();
        item.setName("TestItem");
        item.setType("MANUFACTURED");
        item.setPrice(100.0);
        item.setQuantity(2);

        assertEquals("TestItem", item.getName());
        assertEquals(ItemType.MANUFACTURED, item.getType());
        assertEquals(100.0, item.getPrice());
        assertEquals(2, item.getQuantity());
    }
}
