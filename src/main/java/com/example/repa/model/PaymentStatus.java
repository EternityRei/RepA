package com.example.repa.model;

public enum PaymentStatus {
    NOT_PAID(1),
    PAID(2),
    CANCELED(3);

    private final long paymentStatus;

    PaymentStatus(long paymentStatus){
        this.paymentStatus = paymentStatus;
    }

    public long getPaymentStatus() {
        return paymentStatus;
    }
}
