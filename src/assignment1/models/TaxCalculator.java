package assignment1.models;

import assignment1.enums.ItemType;

public class TaxCalculator {
    private static final double RAW_TAX_RATE = 0.125;
    private static final double MANUFACTURED_BASE_TAX_RATE = 0.125;
    private static final double MANUFACTURED_SURCHARGE_RATE = 0.02;
    private static final double IMPORT_DUTY_RATE = 0.10;
    private static final double SURCHARGE_LOW = 5;
    private static final double SURCHARGE_MEDIUM = 10;
    private static final double SURCHARGE_HIGH_RATE = 0.05;

    private final ItemType type;
    private final double price;

    public TaxCalculator(ItemType type, double price) {
        this.type = type;
        this.price = price;
    }

    public double calculateTax() {
        switch (type) {
            case RAW:
                return price * RAW_TAX_RATE;
            case MANUFACTURED:
                return price * MANUFACTURED_BASE_TAX_RATE + (price * (1 + MANUFACTURED_BASE_TAX_RATE)) * MANUFACTURED_SURCHARGE_RATE;
            case IMPORTED:
                double importDuty = price * IMPORT_DUTY_RATE;
                double surcharge = calculateSurcharge(price + importDuty);
                return importDuty + surcharge;
            default:
                throw new IllegalArgumentException("Invalid item type: " + type);
        }
    }

    private double calculateSurcharge(double costAfterTax) {
        if (costAfterTax <= 100) {
            return SURCHARGE_LOW;
        } else if (costAfterTax <= 200) {
            return SURCHARGE_MEDIUM;
        } else {
            return costAfterTax * SURCHARGE_HIGH_RATE;
        }
    }
}
