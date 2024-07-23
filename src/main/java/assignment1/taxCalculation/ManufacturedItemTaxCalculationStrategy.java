package main.java.assignment1.taxCalculation;

import main.java.assignment1.constants.TaxRateConstants;

public class ManufacturedItemTaxCalculationStrategy implements TaxCalculationInterface {
  @Override
  public double calculate(double price) {
    return price * TaxRateConstants.BASE_TAX_RATE
        + (price * (1 + TaxRateConstants.BASE_TAX_RATE))
        * TaxRateConstants.MANUFACTURED_SURCHARGE_RATE;
  }
}
