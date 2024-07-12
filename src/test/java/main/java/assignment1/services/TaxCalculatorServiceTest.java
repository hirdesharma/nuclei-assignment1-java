package main.java.assignment1.services;

import main.java.assignment1.enums.ItemType;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaxCalculatorServiceTest {

    @Test
    public void testCalculateTaxRaw() {
        TaxCalculatorService calculateTaxTest = new TaxCalculatorService();
        assertEquals(12.5,calculateTaxTest.calculateTax(ItemType.RAW,100));
    }
    @Test
    public void testCalculateTaxManufactured() {
        TaxCalculatorService calculateTaxTest = new TaxCalculatorService();
        assertEquals(16.815,calculateTaxTest.calculateTax(ItemType.MANUFACTURED,114));
    }
    @Test
    public void testCalculateTaxImportedHighSurcharge() {
        TaxCalculatorService calculateTaxTest = new TaxCalculatorService();
        assertEquals(39.99,calculateTaxTest.calculateTax(ItemType.IMPORTED,258));
    }
    @Test
    public void testCalculateTaxImportedMediumSurcharge() {
        TaxCalculatorService calculateTaxTest = new TaxCalculatorService();
        assertEquals(20,calculateTaxTest.calculateTax(ItemType.IMPORTED,100));
    }
    @Test
    public void testCalculateTaxImportedLowSurcharge() {
        TaxCalculatorService calculateTaxTest = new TaxCalculatorService();
        assertEquals(10,calculateTaxTest.calculateTax(ItemType.IMPORTED,50));
    }
}
