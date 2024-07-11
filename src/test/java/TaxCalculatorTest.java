import main.java.assignment1.models.TaxCalculator;
import main.java.assignment1.enums.ItemType;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaxCalculatorTest {

    @Test
    public void testCalculateTaxRaw() {
        TaxCalculator calculateTaxTest = new TaxCalculator();
        assertEquals(12.5,calculateTaxTest.calculateTax(ItemType.RAW,100));
    }
    @Test
    public void testCalculateTaxManufactured() {
        TaxCalculator calculateTaxTest = new TaxCalculator();
        assertEquals(16.815,calculateTaxTest.calculateTax(ItemType.MANUFACTURED,114));
    }
    @Test
    public void testCalculateTaxImportedHighSurcharge() {
        TaxCalculator calculateTaxTest = new TaxCalculator();
        assertEquals(39.99,calculateTaxTest.calculateTax(ItemType.IMPORTED,258));
    }
    @Test
    public void testCalculateTaxImportedMediumSurcharge() {
        TaxCalculator calculateTaxTest = new TaxCalculator();
        assertEquals(20,calculateTaxTest.calculateTax(ItemType.IMPORTED,100));
    }
    @Test
    public void testCalculateTaxImportedLowSurcharge() {
        TaxCalculator calculateTaxTest = new TaxCalculator();
        assertEquals(10,calculateTaxTest.calculateTax(ItemType.IMPORTED,50));
    }
}
