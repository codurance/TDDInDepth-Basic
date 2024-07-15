package com.codurance.module1.TestDoubles.Stub;

public class PaymentChargeFailed extends Exception {
    public PaymentChargeFailed(String message) {
        super(message);
    }

    public static PaymentChargeFailed with(double amount) {
        return new PaymentChargeFailed("Payment charge failed for amount of: " + amount);
    }
}
