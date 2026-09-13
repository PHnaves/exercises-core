package com.phnaves.exercises4.section1;

public enum PaymentMethod {
    CARD("Cartao de credito", 4),
    PIX("Pix", 5),
    TICKET("Boleto", 3);

    private String type;
    private double tax;

    PaymentMethod(String type, double tax) {
        this.type = type;
        this.tax = tax;
    }

    public String getType() {
        return type;
    }

    public double getTax() {
        return tax;
    }

    public double calculationTax(double value) {
        return value + (value * (this.getTax() / 100));
    }
}
