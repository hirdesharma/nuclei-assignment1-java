package main.java.assignment1.taxCalculation;

import main.java.assignment1.constants.TaxRateConstants;

public class RawItemTaxCalculationStrategy implements TaxCalculationInterface {
  @Override
  public double calculate(double price) {
    return price * TaxRateConstants.BASE_TAX_RATE;
  }
}