package com.vikastium.service;

import com.vikastium.util.FormatUtil;

public class TaxService {
    private double saleTaxRate;

    public TaxService() {
    }

    public double getSaleTaxRate() {
        return saleTaxRate;
    }

    public void setSaleTaxRate(double saleTaxRate) {
        this.saleTaxRate = saleTaxRate;
    }

    public String getTax(double amount) {
        return FormatUtil.format(saleTaxRate * amount / 100);
    }
}
