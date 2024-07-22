package main.java.assignment1.services;

import main.java.assignment1.enums.ItemType;
import main.java.assignment1.constants.TaxRateConstants;
import main.java.assignment1.exceptions.InvalidArgument;

import java.util.HashMap;
import java.util.Map;
import main.java.assignment1.taxCalculation.ImportedItemTaxCalculationStrategy;
import main.java.assignment1.taxCalculation.ManufacturedItemTaxCalculationStrategy;
import main.java.assignment1.taxCalculation.RawItemTaxCalculationStrategy;
import main.java.assignment1.taxCalculation.TaxCalculationInterface;

public class TaxCalculatorService implements TaxCalculatorServiceInterface {

    private final Map<ItemType, TaxCalculationInterface> taxStrategyMap;

    public TaxCalculatorService() {
        taxStrategyMap = new HashMap<>();
        taxStrategyMap.put(ItemType.RAW, new RawItemTaxCalculationStrategy());
        taxStrategyMap.put(ItemType.MANUFACTURED, new ManufacturedItemTaxCalculationStrategy());
        taxStrategyMap.put(ItemType.IMPORTED, new ImportedItemTaxCalculationStrategy());
    }

    @Override
    public double calculateTax(ItemType type, Double price) {
        if (price == null || price < 0) {
            throw new InvalidArgument("Price should be a positive number");
        }

        TaxCalculationInterface strategy = taxStrategyMap.get(type);
        if (strategy == null) {
            throw new InvalidArgument("Invalid item type: " + type);
        }

        return strategy.calculate(price);
    }

    public static double calculateSurcharge(double costAfterTax) {
        if (costAfterTax <= 100) {
            return TaxRateConstants.SURCHARGE_LOW;
        } else if (costAfterTax <= 200) {
            return TaxRateConstants.SURCHARGE_MEDIUM;
        } else {
            return costAfterTax * TaxRateConstants.SURCHARGE_HIGH_RATE;
        }
    }
}
