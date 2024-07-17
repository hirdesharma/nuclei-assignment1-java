package main.java.assignment1.services;

import main.java.assignment1.enums.ItemType;

import main.java.assignment1.exceptions.InvalidArgument;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaxCalculatorServiceTest {
    TaxCalculatorService calculateTaxTest = new TaxCalculatorService();

    @Test
    public void testCalculateTaxRaw() {
        assertEquals(12.5,calculateTaxTest.calculateTax(ItemType.RAW,100.0));
    }
    @Test
    public void testCalculateTaxManufactured() {
        assertEquals(16.815,calculateTaxTest.calculateTax(ItemType.MANUFACTURED,114.0));
    }
    @Test
    public void testCalculateTaxImportedHighSurcharge() {
        assertEquals(39.99,calculateTaxTest.calculateTax(ItemType.IMPORTED,258.0));
    }
    @Test
    public void testCalculateTaxImportedMediumSurcharge() {
        assertEquals(20,calculateTaxTest.calculateTax(ItemType.IMPORTED,100.0));
    }
    @Test
    public void testCalculateTaxImportedLowSurcharge() {
        assertEquals(10,calculateTaxTest.calculateTax(ItemType.IMPORTED,50.0));
    }
    @Test
    public void testCalculateTaxNegativeNumber(){
        assertThrows(InvalidArgument.class, () -> {
            calculateTaxTest.calculateTax(ItemType.RAW,-100.0);
        });
    }
    @Test
    public void testCalculateTaxNull(){
        assertThrows(InvalidArgument.class, () -> {
            calculateTaxTest.calculateTax(ItemType.RAW,null);
        });
    }
    @Test
    public void testCalculateTaxZeroNumber(){
        assertEquals(0,calculateTaxTest.calculateTax(ItemType.RAW,0.0));
    }
}
