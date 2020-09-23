package com.example.tesltraprecticeapp.override;

public class Gst extends IncomeTax {
    @Override
    public int calculateTax(int income) {
        int previousTax = super.calculateTax(income);
        int gst = previousTax + previousTax/10;
        return gst;
    }
}
