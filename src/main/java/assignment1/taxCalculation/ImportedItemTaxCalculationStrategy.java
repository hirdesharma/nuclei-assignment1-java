package main.java.assignment1.taxCalculation;

import main.java.assignment1.constants.TaxRateConstants;
import main.java.assignment1.services.TaxCalculatorService;

public class ImportedItemTaxCalculationStrategy implements TaxCalculationInterface {
  @Override
  public double calculate(double price) {
    double importDuty = price * TaxRateConstants.IMPORT_DUTY_RATE;
    double surcharge = TaxCalculatorService.calculateSurcharge(price + importDuty);
    return importDuty + surcharge;
  }
}
