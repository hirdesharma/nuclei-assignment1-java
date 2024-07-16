package main.java.assignment1.services;

import main.java.assignment1.enums.ItemType;
import main.java.assignment1.constants.TaxRateConstants;
import main.java.assignment1.exceptions.InvalidArgument;

public class TaxCalculatorService {

    public double calculateTax(ItemType type, double price) {
        if(price<0)throw new InvalidArgument("price should be a positive number");
        switch (type) {
            case RAW:
                return price * TaxRateConstants.BASE_TAX_RATE;
            case MANUFACTURED:
                return price * TaxRateConstants.BASE_TAX_RATE + (price * (1 + TaxRateConstants.BASE_TAX_RATE)) * TaxRateConstants.MANUFACTURED_SURCHARGE_RATE;
            case IMPORTED:
                double importDuty = price * TaxRateConstants.IMPORT_DUTY_RATE;
                double surcharge = calculateSurcharge(price + importDuty);
                return importDuty + surcharge;
            default:
                throw new InvalidArgument("Invalid item type: " + type);
        }
    }

    private double calculateSurcharge(double costAfterTax) {
        if (costAfterTax <= 100) {
            return TaxRateConstants.SURCHARGE_LOW;
        } else if (costAfterTax <= 200) {
            return TaxRateConstants.SURCHARGE_MEDIUM;
        } else {
            return costAfterTax * TaxRateConstants.SURCHARGE_HIGH_RATE;
        }
    }
}
