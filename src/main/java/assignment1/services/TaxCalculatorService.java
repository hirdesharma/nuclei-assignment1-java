package main.java.assignment1.services;

import main.java.assignment1.enums.ItemType;

public class TaxCalculatorService {
    private static final double BASE_TAX_RATE = 0.125;
    private static final double MANUFACTURED_SURCHARGE_RATE = 0.02;
    private static final double IMPORT_DUTY_RATE = 0.10;
    private static final double SURCHARGE_LOW = 5;
    private static final double SURCHARGE_MEDIUM = 10;
    private static final double SURCHARGE_HIGH_RATE = 0.05;

    public double calculateTax(ItemType type, double price) {
        switch (type) {
            case RAW:
                return price * BASE_TAX_RATE;
            case MANUFACTURED:
                return price * BASE_TAX_RATE + (price * (1 + BASE_TAX_RATE)) * MANUFACTURED_SURCHARGE_RATE;
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
